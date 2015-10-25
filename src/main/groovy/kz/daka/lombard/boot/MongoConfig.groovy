package kz.daka.lombard.boot

import com.mongodb.Mongo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration

/**
 * Created by root on 10/24/15.
 */

@Configuration
class MongoConfig extends AbstractMongoConfiguration {

    private static String databaseName = "lombard"

    @Override
    protected String getDatabaseName() {
        return MongoConfig.databaseName
    }

    @Override
    @Bean
    Mongo mongo() throws Exception {
        return new Mongo("127.0.0.1")
    }

    @Override
    protected String getMappingBasePackage() {
        return "kz.daka.lombard.entities"
    }
}
