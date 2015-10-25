package kz.daka.lombard.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Created by root on 10/24/15.
 */

@Document(collection = Sequence.COLLECTION_NAME)
class Sequence {

    private static final String COLLECTION_NAME = "Sequence"

    @Id
    String _id
    Long value

}
