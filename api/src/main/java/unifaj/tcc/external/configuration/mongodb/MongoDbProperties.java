package unifaj.tcc.external.configuration.mongodb;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@ConstructorBinding
@ConfigurationProperties("mongo-properties")
public class MongoDbProperties {

    private String url;
    private String host;
    private String port;
    private String database;
    private String username;
    private String password;
}
