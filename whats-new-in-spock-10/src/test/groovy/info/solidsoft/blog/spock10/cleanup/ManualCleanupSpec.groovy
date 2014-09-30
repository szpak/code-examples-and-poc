package info.solidsoft.blog.spock10.cleanup

import info.solidsoft.blog.spock10.cleanup.db.DBConnection
import info.solidsoft.blog.spock10.cleanup.db.H2DBConnection
import spock.lang.Shared
import spock.lang.Specification


class ManualCleanupSpec extends Specification {

    @Shared
    private DBConnection dbConnection = new H2DBConnection()

    void cleanupSpec() {
        dbConnection.close()
    }

    def "should do fancy thing on DB"() {
        expect:
            1
    }
}
