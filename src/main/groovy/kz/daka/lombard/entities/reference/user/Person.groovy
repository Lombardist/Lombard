package kz.daka.lombard.entities.reference.user

import kz.daka.lombard.entities.reference.address.Address
import kz.daka.lombard.entities.reference.phone.Phone
import org.springframework.data.annotation.Id

/**
 * Created by root on 10/24/15.
 */
abstract class Person {

    @Id
    Long _id

    //Global identification number, IIN for example
    String identificationNumber

    String lastName
    String name
    Gender gender
    Date birthDate
    List<Address> addressList
    List<Phone> phoneList

}
