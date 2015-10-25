package kz.daka.lombard.entities.reference.address

import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id

/**
 * Created by root on 10/24/15.
 */

@Document(collection = AddressReference.ADDRESS_REFERENCE)
class AddressReference {

    static final String ADDRESS_REFERENCE = "AddressReference"

    @Id
    Long _id

    Long parentId
    AddressElementType elementType
    String elementName

}
