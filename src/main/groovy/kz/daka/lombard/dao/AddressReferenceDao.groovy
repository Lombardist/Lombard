package kz.daka.lombard.dao

import kz.daka.lombard.entities.reference.address.AddressReference
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

/**
 * Created by root on 10/24/15.
 */

@Repository
class AddressReferenceDao {

    @Autowired
    private MongoOperations mongoOperations

    @Autowired
    private SequenceDao sequenceDao

    AddressReference getAddressReferenceById(Long id) {
        mongoOperations.findOne(Query.query(Criteria.where("_id").is(id)), AddressReference.class)
    }

    AddressReference addAddressReference(AddressReference reference) {
        Objects.requireNonNull(reference, "AddressReference cannot be NULL")
        if (!Objects.nonNull(reference._id)) {
            reference._id = sequenceDao.getNextId(AddressReference.ADDRESS_REFERENCE)
        }
        mongoOperations.save(reference)
        reference
    }

    List<AddressReference> getAddressReferences(Long parentId) {
        def criteria = Objects.nonNull(parentId) ? parentId : null
        mongoOperations.find(Query.query(Criteria.where("parentId").is(criteria)), AddressReference.class)
    }

}
