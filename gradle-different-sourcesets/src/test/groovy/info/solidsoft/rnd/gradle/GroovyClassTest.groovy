package info.solidsoft.rnd.gradle

import groovy.transform.TypeChecked
import spock.lang.Specification

@TypeChecked
class GroovyClassTest extends Specification {

    private static final int TEST_VALUE = 2

    def "should return given value"() {
        given:
            def groovyClass = new GroovyClass()
        when:
            def returnedValue = groovyClass.returnInputValue(TEST_VALUE)
        then:
            returnedValue == TEST_VALUE
    }
}
