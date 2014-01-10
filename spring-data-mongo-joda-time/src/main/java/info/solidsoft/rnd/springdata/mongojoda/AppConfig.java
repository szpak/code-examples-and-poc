package info.solidsoft.rnd.springdata.mongojoda;

import com.mongodb.Mongo;
import com.mongodb.WriteConcern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Marcin Zajączkowski, 2013-12-16
 */
@Configuration  //comment this annotation to make test fail with: ConverterNotFoundException: No converter found capable of converting from type org.joda.time.DateTime to type java.util.Date
@ComponentScan
@EnableMongoRepositories
public class AppConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "mongo-joda";
    }

    @Bean
    @Override
    public Mongo mongo() throws Exception {
        Mongo mongo = new Mongo();
        mongo.setWriteConcern(WriteConcern.SAFE);
        return mongo;
    }
}
