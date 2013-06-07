package info.solidsoft.rnd.pit.spock

import groovy.transform.TypeChecked
import spock.lang.Specification

@TypeChecked
class CrashTestDummyForPitSpockTest extends Specification {

    def "should generate coverage for return3Spock method in TestDummyForPit"() {
        given:
        def testDummyForPit = new CrashTestDummyForPit()

        when:
        int result = testDummyForPit.return3Spock()

        then:
        assert result == 3
    }
}
