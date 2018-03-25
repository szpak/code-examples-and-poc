package info.solidsoft.blog.mockito.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class SpaceShip5BugMiniTest {

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
        assertThat(spaceShip.getTacticalStation()).isEqualTo(tacticalStation);  //Bug - different mocks are use in @Mock and @InjectMock
        assertThat(spaceShip.getOperationsStation()).isEqualTo(operationsStation);
    }
}
