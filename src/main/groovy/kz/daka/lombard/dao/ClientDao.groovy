package kz.daka.lombard.dao

import kz.daka.lombard.entities.reference.user.Client
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository

/**
 * Created by root on 10/25/15.
 */

@Repository
class ClientDao {

    @Autowired
    private MongoOperations mongoOperations

    @Autowired
    private SequenceDao sequenceDao

    Client getClientById(Long id) {
        mongoOperations.findOne(Query.query(Criteria.where("_id").is(id)), Client.class)
    }

    Client addClient(Client client) {
        if (!Objects.nonNull(client._id)) {
            client._id = sequenceDao.getNextId(Client.CLIENT_COLLECTION)
        }
        mongoOperations.save(client)
        client
    }

    List<Client> getAllClients() {
        mongoOperations.findAll(Client.class)
    }

}
