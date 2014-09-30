package info.solidsoft.blog.spock10.cleanup

import spock.lang.Specification
import spock.lang.Stepwise
import spock.util.mop.ConfineMetaClassChanges


@Stepwise
class ConfineMetaClassChangesSpec extends Specification {

    @ConfineMetaClassChanges(EmptyClass)
    def "should allow to call added method"() {
        given:
            EmptyClass.metaClass.returnFoo = { "foo" }
        when:
            def fooValue = new EmptyClass().returnFoo()
        then:
            fooValue == "foo"

    }

    def "should throw exception on not available method"() {
        when:
            new EmptyClass().returnFoo()
        then:
            thrown(MissingMethodException)
    }

    class EmptyClass {
    }
}

