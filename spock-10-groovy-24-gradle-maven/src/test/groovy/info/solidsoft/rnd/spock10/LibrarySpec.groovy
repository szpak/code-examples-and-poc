package info.solidsoft.rnd.spock10

import spock.lang.Specification

class LibrarySpec extends Specification {

    def "someLibraryMethod returns true"() {
        setup:
            Library lib = new Library()
        when:
            def result = lib.someLibraryMethod()
        then:
            //implicit Spock assertion/condition
            result
    }
}
