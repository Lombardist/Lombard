package kz.daka.lombard.service.address

import kz.daka.lombard.dao.AddressReferenceDao
import kz.daka.lombard.entities.reference.address.AddressElementType
import kz.daka.lombard.entities.reference.address.AddressReference
import kz.daka.lombard.rest.address.entities.AddressReferenceWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by root on 10/25/15.
 */

@Service
class AddressReferenceService {

    @Autowired
    private AddressReferenceDao addressReferenceDao

    AddressReferenceWrapper addAddressReference(AddressReferenceWrapper addressReferenceWrapper) {
        def address = new AddressReference()
        address._id = addressReferenceWrapper.id
        address.elementName = addressReferenceWrapper.elementName
        address.elementType = AddressElementType.valueOf(addressReferenceWrapper.elementType)
        address.parentId = Objects.nonNull(addressReferenceWrapper.parentId) ? addressReferenceWrapper.parentId : null
        address = addressReferenceDao.addAddressReference(address)
        addressReferenceWrapper.id = address._id
        addressReferenceWrapper
    }

    List<AddressReferenceWrapper> getAddressReferences(Long parentId) {
        List<AddressReference> addressReferenceList = addressReferenceDao.getAddressReferences(parentId)
        addressReferenceList.collect { element ->
            AddressReferenceWrapper obj = new AddressReferenceWrapper()
            obj.id = element._id
            obj.parentId = Objects.nonNull(element.parentId) ? element.parentId : null
            obj.elementName = element.elementName
            obj.elementType = element.elementType.name()
            obj
        }
    }

    List<String> getAddressElementTypes() {
        AddressElementType.values().collect { type ->
            type.name()
        }
    }

    //Retrieves the whole address line from selected AddressReference ID
    String getAddressPath(Long id) {
        AddressReference ref = addressReferenceDao.getAddressReferenceById(id)
        Objects.requireNonNull(ref)
        String result = ""
        while (ref != null) {
            result += "${ref.elementName} "
            ref = addressReferenceDao.getAddressReferenceById(ref.parentId)
        }
        result
    }

}
