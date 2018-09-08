package info.solidsoft.blog.spock12.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShipDatabase {
    private final OwnShipIndex ownShipIndex;
    private final EnemyShipIndex enemyShipIndex;

    public ShipDatabase(OwnShipIndex ownShipIndex, EnemyShipIndex enemyShipIndex) {
        this.ownShipIndex = ownShipIndex;
        this.enemyShipIndex = enemyShipIndex;
    }

    public List<String> findByName(String shipName) {
        return Stream.concat(ownShipIndex.findByName(shipName).stream(), enemyShipIndex.findByName(shipName)
                .stream())
                .collect(Collectors.toList());
    }
}
