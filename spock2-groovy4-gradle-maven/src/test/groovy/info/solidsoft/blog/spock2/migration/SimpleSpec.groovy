package info.solidsoft.blog.spock2.migration

import spock.lang.Specification

class SimpleSpec extends Specification {

    void "should be executed and pass"() {
        expect:
            GroovySystem.getShortVersion() == "4.0"
    }

    void "should verify parametrized tests execution"() {
        expect:
            number > 0
        where:
            number << [1, 2]
    }

}
