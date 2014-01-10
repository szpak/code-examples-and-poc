package info.solidsoft.rnd.springdata.mongojoda;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

/**
 * @author Marcin Zajączkowski, 2013-12-16
 */
@Document
public class JodaDoc {

    @Id
    private BigInteger id;

    private String dateAsString;

    private DateTime date;

    public JodaDoc(String dateAsString, DateTime date) {
        this.dateAsString = dateAsString;
        this.date = date;
    }

    public BigInteger getId() {
        return id;
    }

    public String getDateAsString() {
        return dateAsString;
    }

    public DateTime getDate() {
        return date;
    }
}
