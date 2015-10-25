package kz.daka.lombard.entities

import kz.daka.lombard.entities.reference.address.Address
import kz.daka.lombard.entities.reference.phone.Phone
import kz.daka.lombard.entities.reference.user.User
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by root on 10/24/15.
 */

@Document(collection = Pawnshop.PAWNSHOP_COLLECTION)
class Pawnshop {

    static final String PAWNSHOP_COLLECTION = "Pawnshop"

    @Id
    Long _id

    @DBRef
    Company company

    String name
    String description
    Address address
    List<Phone> phones

    //Users who are related to this Pawnshop
    List<User> userList

    User globalDirector

}
