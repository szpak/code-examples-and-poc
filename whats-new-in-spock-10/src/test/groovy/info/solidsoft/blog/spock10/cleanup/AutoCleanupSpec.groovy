package info.solidsoft.blog.spock10.cleanup

import info.solidsoft.blog.spock10.cleanup.db.DBConnection
import info.solidsoft.blog.spock10.cleanup.db.H2DBConnection
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class AutoCleanupSpec extends Specification {

    @AutoCleanup
    @Shared
    private DBConnection dbConnection = new H2DBConnection()

    def "should do fancy thing on DB"() {
        expect:
            1
    }
}


