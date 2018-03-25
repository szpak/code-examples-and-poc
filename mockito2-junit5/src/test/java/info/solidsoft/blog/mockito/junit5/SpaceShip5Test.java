package info.solidsoft.blog.mockito.junit5;

import info.solidsoft.mockito.java8.api.WithBDDMockito;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SpaceShip5Test implements WithAssertions, WithBDDMockito {

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
