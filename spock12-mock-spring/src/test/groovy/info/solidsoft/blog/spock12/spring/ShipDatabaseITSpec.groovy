package info.solidsoft.blog.spock12.spring

import info.solidsoft.blog.spock12.model.EnemyShipIndex
import info.solidsoft.blog.spock12.model.OwnShipIndex
import info.solidsoft.blog.spock12.model.ShipDatabase
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

//@ContextConfiguration just for simplification, @(Test)Configuration is usually more convenient for Spring Boot tests
//Real beans can exist in the context or not
@ContextConfiguration(classes = [ShipDatabase/*, OwnShipIndex, EnemyShipIndex*/])
class ShipDatabaseITSpec extends Specification {

    private static final String ENTERPRISE_D = "USS Enterprise (NCC-1701-D)"
    private static final String BORTAS_ENTERA = "IKS Bortas Entera"

    @SpringBean
    private OwnShipIndex ownShipIndexMock = Stub()  //could be Mock() if needed

    @SpringBean
    private EnemyShipIndex enemyShipIndexMock = Stub()

    @Autowired
    private ShipDatabase shipDatabase

    def "should find ship in both indexes"() {
        given:
            ownShipIndexMock.findByName("Enter") >> [ENTERPRISE_D]
            enemyShipIndexMock.findByName("Enter") >> [BORTAS_ENTERA]
        when:
            List<String> foundShips = shipDatabase.findByName("Enter")
        then:
            foundShips == [ENTERPRISE_D, BORTAS_ENTERA]
    }
}
