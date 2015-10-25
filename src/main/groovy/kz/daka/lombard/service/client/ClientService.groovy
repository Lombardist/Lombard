package kz.daka.lombard.service.client

import kz.daka.lombard.dao.ClientDao
import kz.daka.lombard.entities.reference.user.Client
import kz.daka.lombard.entities.reference.user.Gender
import kz.daka.lombard.rest.client.entities.ClientWrapper
import kz.daka.lombard.rest.entities.AddressWrapper
import kz.daka.lombard.rest.entities.PhoneWrapper
import kz.daka.lombard.service.address.AddressReferenceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by root on 10/25/15.
 */

@Service
class ClientService {

    @Autowired
    private ClientDao clientDao

    @Autowired
    private AddressReferenceService addressReferenceService

    ClientWrapper addClient(ClientWrapper client) {
        Client obj = new Client()
        obj._id = client.id
        obj.birthDate = client.birthDate
        obj.gender = Gender.valueOf(client.gender)
        obj.name = client.name
        obj.lastName = client.lastName
        obj.identificationNumber = client.identificationNumber
        clientDao.addClient(obj)
        client.id = obj._id
        client
    }

    ClientWrapper updateClient(ClientWrapper client) {

    }

    ClientWrapper getClientById(Long id) {
        Objects.requireNonNull(id)
        def client = clientDao.getClientById(id)
        ClientWrapper result = new ClientWrapper()
        result.id = client._id
        result.identificationNumber = client.identificationNumber
        result.name = client.name
        result.lastName = client.lastName
        result.birthDate = client.birthDate
        result.gender = client.gender.name()

        result.addressList = client.addressList.collect { address ->
            AddressWrapper add = new AddressWrapper()
            add.addressLine = addressReferenceService.getAddressPath(address.reference._id)
            add.addressType = address.addressType.name()
            add.reference = address.reference._id
            add.apartmentNumber = address.apartmentNumber
            add.buildingNumber = address.buildingNumber
            add.description = address.description
            add
        }

        result.phoneList = client.phoneList.collect { phone ->
            PhoneWrapper pho = new PhoneWrapper()
            pho.countryCode = phone.countryCode
            pho.number = phone.number
            pho.phoneType = phone.phoneType.name()
            pho
        }
    }

}
