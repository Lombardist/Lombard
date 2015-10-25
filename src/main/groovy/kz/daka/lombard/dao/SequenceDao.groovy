package kz.daka.lombard.dao

import kz.daka.lombard.entities.Sequence
import kz.daka.lombard.exceptions.SequenceException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Repository

/**
 * Created by root on 10/24/15.
 */

@Repository
class SequenceDao {

    @Autowired
    private MongoOperations mongoOperations

    Long getNextId(String collection) {

        Query query = new Query(Criteria.where("_id").is(collection));

        Update update = new Update();
        update.inc("value", 1);

        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);

        Sequence sequence = mongoOperations.findAndModify(query, update, options, Sequence.class);

        if (sequence == null) {
            sequence = new Sequence()
            sequence._id = collection
            sequence.value = 1
            mongoOperations.save(sequence)
        }

        return sequence.value
    }

}
