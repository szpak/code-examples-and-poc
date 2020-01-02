package info.solidsoft.blog.spock2.migration

import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification

class Spock2RuleSpec extends Specification {

    @Rule
    public TemporaryFolder tmpDir = new TemporaryFolder()

    def "should allow to use JUnit4 Rule in Spock 2 test"() {
        when:
            File testFile = tmpDir.newFile("testFile")
        then:
            testFile.exists()
    }
}
