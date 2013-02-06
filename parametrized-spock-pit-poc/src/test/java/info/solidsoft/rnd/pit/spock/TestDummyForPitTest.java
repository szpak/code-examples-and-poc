package info.solidsoft.rnd.pit.spock;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class TestDummyForPitTest {

    @Test
    public void shouldGenerateCoverageForJUnit() {
        //given
        TestDummyForPit testDummyForPit = new TestDummyForPit();
        //when
        int result = testDummyForPit.return1Junit();
        //then
        assertThat(result).isEqualTo(1);
    }
}
