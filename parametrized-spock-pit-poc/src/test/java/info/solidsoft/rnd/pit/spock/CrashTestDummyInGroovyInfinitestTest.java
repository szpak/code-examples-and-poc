package info.solidsoft.rnd.pit.spock;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CrashTestDummyInGroovyInfinitestTest {

    @Test
    public void shouldTriggerIninitestOnChangeInProductionClassInGroovy() {
        //given
        CrashTestDummyInGroovy crashTestDummyForPit = new CrashTestDummyInGroovy();
        //when
        int result = crashTestDummyForPit.returnInputValue(1);
        //then
        assertThat(result).isEqualTo(1);
    }

}
