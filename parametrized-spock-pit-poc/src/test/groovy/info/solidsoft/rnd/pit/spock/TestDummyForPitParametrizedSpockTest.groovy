package info.solidsoft.rnd.pit.spock

import groovy.transform.TypeChecked
import spock.lang.Specification
import spock.lang.Unroll

@TypeChecked
class TestDummyForPitParametrizedSpockTest extends Specification{

    def testDummyForPit = new TestDummyForPit()

    @Unroll
    def "should get list of lengths for given strings"(int input, int expectedResult) {
        expect:
        testDummyForPit.returnParametrizedSpock(input) == expectedResult

        where:
        input | expectedResult
        1     | 1
        2     | 2
        3     | 3
    }
}
