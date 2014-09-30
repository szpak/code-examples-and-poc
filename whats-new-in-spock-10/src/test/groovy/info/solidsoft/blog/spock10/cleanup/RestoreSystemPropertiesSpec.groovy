package info.solidsoft.blog.spock10.cleanup

import spock.lang.Specification
import spock.lang.Stepwise
import spock.util.environment.RestoreSystemProperties

@Stepwise
class RestoreSystemPropertiesSpec extends Specification {

    @RestoreSystemProperties
    def "should deny perform action when running as root"() {
        given:
            System.setProperty("user.name", "root")
        and:
            def sut = new DangerousActionPerformer()
        when:
            sut.squashThemAll()
        then:
            thrown(IllegalStateException)
    }

    def "should perform action when running as 'normal' user"() {
        given:
            def sut = new DangerousActionPerformer()
        when:
            sut.squashThemAll()
        then:
            noExceptionThrown()
    }

    class DangerousActionPerformer {
        void squashThemAll() {
            if (isRunningAsRoot()) {
                throw new IllegalStateException("Do not run this operation as root!!!")
            }
            println "Squashing all commits everywhere!"
        }

        boolean isRunningAsRoot() {
            //Ignoring Windows for now :)
            "root".equals(System.getProperty("user.name"))
        }
    }
}
