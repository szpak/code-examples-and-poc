package info.solidsoft.blog.spock10.requires

import spock.lang.Requires
import spock.lang.Specification

//This import is required to prevent: groovy.lang.MissingMethodException
import static FancyFeatureRequiredIntranetConnectionSpecIT.isUrlAvailable

@Requires({ isUrlAvailable("http://some-host.intranet/") })
class FancyFeatureRequiredIntranetConnectionSpecIT extends Specification {

    //could be also from trait or other class
    static boolean isUrlAvailable(String url) {
        false
    }

    def "should do one thing in intranet"() {
        expect:
            true
    }

    def "should do another thing in intranet"() {
        expect:
            true
    }
}