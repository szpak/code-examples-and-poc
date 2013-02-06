package info.solidsoft.rnd.pit.spock;

import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

@Test
public class TestDummyForPitTestNGTest {

    public void shouldGenerateCoverageForTestNG() {
        //given
        TestDummyForPit testDummyForPit = new TestDummyForPit();
        //when
        int result = testDummyForPit.return2TestNG();
        //then
        assertThat(result).isEqualTo(2);
    }
}
