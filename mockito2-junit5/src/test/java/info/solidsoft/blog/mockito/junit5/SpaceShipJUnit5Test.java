package info.solidsoft.blog.mockito.junit5;

import info.solidsoft.mockito.java8.api.WithBDDMockito;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class SpaceShipJUnit5Test implements WithAssertions, WithBDDMockito {

    @Mock
    private TacticalStation tacticalStation;

    @Mock
    private OperationsStation operationsStation;

    @InjectMocks
    private SpaceShip spaceShip;

    @Test
    void shouldInjectMocks() {
        assertThat(spaceShip).isNotNull();
        assertThat(tacticalStation).isNotNull();
        assertThat(operationsStation).isNotNull();
        assertThat(spaceShip.getTacticalStation()).isSameAs(tacticalStation);
        assertThat(spaceShip.getOperationsStation()).isSameAs(operationsStation);
    }

    @Test
    void shouldVerifySomeBehavior() {
        //when
        spaceShip.doSelfCheck();
        //then
        then(tacticalStation).should().doSelfCheck();
        then(operationsStation).should().doSelfCheck();
    }

    @Test
    void shouldMockSomething() {
        //given
        willThrow(SelfCheckException.class).given(tacticalStation).doSelfCheck();
        //when
        Executable e = () -> spaceShip.doSelfCheck();
        //then
        assertThrows(SelfCheckException.class, e);
    }
}
