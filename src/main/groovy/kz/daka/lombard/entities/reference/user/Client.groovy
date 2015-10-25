package kz.daka.lombard.entities.reference.user

import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by root on 10/24/15.
 */

@Document(collection = Client.CLIENT_COLLECTION)
class Client extends Person {

    static final String CLIENT_COLLECTION = "Client"

}
