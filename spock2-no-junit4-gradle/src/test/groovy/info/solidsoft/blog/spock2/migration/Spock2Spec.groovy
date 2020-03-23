package info.solidsoft.blog.spock2.migration

import spock.lang.Ignore
import spock.lang.Specification

class Spock2Spec extends Specification {

    def "should execute simple Spock 2 test"() {
        expect:
            1
    }

//    @Ignore
    def "should execute failing Spock 2 test"() {
        expect:
            0
    }
}
