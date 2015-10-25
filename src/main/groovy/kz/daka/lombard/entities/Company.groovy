package kz.daka.lombard.entities

import kz.daka.lombard.entities.reference.address.Address
import kz.daka.lombard.entities.reference.phone.Phone
import kz.daka.lombard.entities.reference.user.User
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by root on 10/24/15.
 */

@Document(collection = Company.COMPANY_COLLECTION)
class Company {

    static final String COMPANY_COLLECTION = "Company"

    @Id
    Long _id
    String name

    //Global identification number, BIN for example
    String identificationNumber
    Address legalAddress
    List<Phone> legalPhones

    //Users who are related to this Company
    List<User> userList

    User superVisor

}
