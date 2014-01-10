package info.solidsoft.rnd.springdata.mongojoda

import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * @author Marcin Zajączkowski, 2013-12-16
 */
@ContextConfiguration(classes = AppConfig)
class JodaDocRepositorySpec extends Specification {

    @Autowired
    private JodaDocRepository jodaDocRepository

    def "save document with DateTime"() {
        given:
            def now = DateTime.now()
            def jodaDoc = new JodaDoc(now.toString(), now)
        when:
            def savedJodaDoc = jodaDocRepository.save(jodaDoc)
        then:
            savedJodaDoc
            savedJodaDoc.id
    }
}
