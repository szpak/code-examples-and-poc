package info.solidsoft.rnd.pit.spock;

import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

@Test
public class CrashTestDummyForPitTestNGTest {

    public void shouldGenerateCoverageForTestNG() {
        //given
        CrashTestDummyForPit crashTestDummyForPit = new CrashTestDummyForPit();
        //when
        int result = crashTestDummyForPit.return2TestNG();
        //then
        assertThat(result).isEqualTo(2);
    }
}
