package unifaj.tcc.external.configuration.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClients;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@RequiredArgsConstructor
@Configuration
public class MongoDbConfiguration {

    private final MongoDbProperties mongoDbProperties;

    @Bean
    public MongoTemplate mongoTemplate() {
        var mongoCredential = MongoCredential.createCredential(mongoDbProperties.getUsername(), mongoDbProperties.getDatabase(), mongoDbProperties.getPassword().toCharArray());
        var mongoClientSettings = createMongoClientSettings(mongoCredential);

        return new MongoTemplate(MongoClients.create(mongoClientSettings), mongoDbProperties.getDatabase());
    }

    private MongoClientSettings createMongoClientSettings(MongoCredential mongoCredential) {
        var connectionString = new ConnectionString(mongoDbProperties.getUrl());

        return MongoClientSettings.builder().applyConnectionString(connectionString).build();
    }
}
