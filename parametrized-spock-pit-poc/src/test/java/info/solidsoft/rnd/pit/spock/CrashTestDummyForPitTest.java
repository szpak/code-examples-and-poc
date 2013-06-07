package info.solidsoft.rnd.pit.spock;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CrashTestDummyForPitTest {

    @Test
    public void shouldGenerateCoverageForJUnit() {
        //given
        CrashTestDummyForPit crashTestDummyForPit = new CrashTestDummyForPit();
        //when
        int result = crashTestDummyForPit.return1Junit();
        //then
        assertThat(result).isEqualTo(1);
    }
}
