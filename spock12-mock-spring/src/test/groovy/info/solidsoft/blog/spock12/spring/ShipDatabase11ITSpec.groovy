package info.solidsoft.blog.spock12.spring

import info.solidsoft.blog.spock12.model.EnemyShipIndex
import info.solidsoft.blog.spock12.model.OwnShipIndex
import info.solidsoft.blog.spock12.model.ShipDatabase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.mock.DetachedMockFactory

//@ContextConfiguration just for simplification, @(Test)Configuration is usually more convenient for Spring Boot tests
//Real beans can exist in the context or not
@ContextConfiguration(classes = [ShipDatabase, TestConfig/*, OwnShipIndex, EnemyShipIndex*/])
//WARNING!!! DetachedMockFactory is no longer needed with Spring 1.2 - see ShipDatabaseITSpec
class ShipDatabase11ITSpec extends Specification {

    private static final String ENTERPRISE_D = "USS Enterprise (NCC-1701-D)"
    private static final String BORTAS_ENTERA = "IKS Bortas Entera"

    @Autowired
    private OwnShipIndex ownShipIndexMock

    @Autowired
    private EnemyShipIndex enemyShipIndexMock

    @Autowired
    private ShipDatabase shipDatabase

    def "should find ship in both indexes (Spock 1.1)"() {
        given:
            ownShipIndexMock.findByName("Enter") >> [ENTERPRISE_D]
            enemyShipIndexMock.findByName("Enter") >> [BORTAS_ENTERA]
        when:
            List<String> foundShips = shipDatabase.findByName("Enter")
        then:
            foundShips == [ENTERPRISE_D, BORTAS_ENTERA]
    }

//    @TestConfiguration
    static class TestConfig {
        private DetachedMockFactory detachedMockFactory = new DetachedMockFactory()

        @Bean
        @Primary    //if needed, beware of consequences
        OwnShipIndex ownShipIndexStub() {
            return detachedMockFactory.Stub(OwnShipIndex)
        }

        @Bean
        @Primary    //if needed, beware of consequences
        EnemyShipIndex enemyShipIndexStub() {
            return detachedMockFactory.Stub(EnemyShipIndex)
        }
    }
}
