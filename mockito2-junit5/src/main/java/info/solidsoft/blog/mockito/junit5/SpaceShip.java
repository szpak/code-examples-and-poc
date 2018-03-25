package info.solidsoft.blog.mockito.junit5;

/**
 * For educational purposes only.
 */
public class SpaceShip {

    private final TacticalStation tacticalStation;
    private final OperationsStation operationsStation;

    public SpaceShip(TacticalStation tacticalStation, OperationsStation operationsStation) {
        this.tacticalStation = tacticalStation;
        this.operationsStation = operationsStation;
    }

    public TacticalStation getTacticalStation() {
        return tacticalStation;
    }

    public OperationsStation getOperationsStation() {
        return operationsStation;
    }

    public void doSelfCheck() {
        tacticalStation.doSelfCheck();
        operationsStation.doSelfCheck();
    }
}
