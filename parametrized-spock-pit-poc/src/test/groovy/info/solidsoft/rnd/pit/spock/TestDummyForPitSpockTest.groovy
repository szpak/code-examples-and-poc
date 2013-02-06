package info.solidsoft.rnd.pit.spock

import groovy.transform.TypeChecked
import spock.lang.Specification

@TypeChecked
class TestDummyForPitSpockTest extends Specification {

    def "should generate coverage for return3Spock method in TestDummyForPit"() {
        given:
        def testDummyForPit = new TestDummyForPit()

        when:
        int result = testDummyForPit.return3Spock()

        then:
        assert result == 3
    }
}
