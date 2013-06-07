package info.solidsoft.rnd.pit.spock

import groovy.transform.TypeChecked
import spock.lang.Specification
import spock.lang.Unroll

@TypeChecked
class CrashTestDummyForPitParametrizedSpockTest extends Specification{

    def testDummyForPit = new CrashTestDummyForPit()

    @Unroll
    def "should get list of lengths (#expectedResult) for given strings (#input)"(int input, int expectedResult) {
        expect:
        testDummyForPit.returnParametrizedSpock(input) == expectedResult

        where:
        input | expectedResult
        1     | 1
        2     | 2
        3     | 3
    }
}
