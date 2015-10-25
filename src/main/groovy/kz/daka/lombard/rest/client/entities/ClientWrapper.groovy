package kz.daka.lombard.rest.client.entities

import kz.daka.lombard.rest.entities.AddressWrapper
import kz.daka.lombard.rest.entities.PhoneWrapper

/**
 * Created by root on 10/25/15.
 */
class ClientWrapper {

    Long id
    String identificationNumber
    String lastName
    String name
    String gender
    Date birthDate
    List<AddressWrapper> addressList = []
    List<PhoneWrapper> phoneList = []

}
