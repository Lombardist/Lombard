package kz.daka.lombard.entities.reference.user

import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by root on 10/24/15.
 */

@Document(collection = User.USER_COLLECTION)
class User extends Person {

    static final String USER_COLLECTION = "User"

    String login
    String passwordHash
    Set<Role> roleSet

}
