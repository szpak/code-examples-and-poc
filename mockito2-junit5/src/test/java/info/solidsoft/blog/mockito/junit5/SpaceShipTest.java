package info.solidsoft.blog.mockito.junit5;

import info.solidsoft.mockito.java8.api.WithBDDMockito;
import org.assertj.core.api.WithAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class SpaceShipTest implements WithAssertions, WithBDDMockito {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    
    @InjectMocks
    private SpaceShip spaceShip;

    @Mock
    private TacticalStation tacticalStation;

    @Mock
    private OperationsStation operationsStation;

    @Test
    public void shouldInjectMocks() {
        assertThat(tacticalStation).isNotNull();
        assertThat(operationsStation).isNotNull();
        assertThat(spaceShip.getTacticalStation()).isEqualTo(tacticalStation);
        assertThat(spaceShip.getOperationsStation()).isEqualTo(operationsStation);
    }
}
