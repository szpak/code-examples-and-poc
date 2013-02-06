package info.solidsoft.rnd.pit.spock;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.fest.assertions.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TestDummyForPitJUnitParamsTest {

    @Test
    @Parameters(method = "getTestInputValues")
    public void shouldGenerateCoverageForJUnitParams(int input, int expectedResult) {
        //given
        TestDummyForPit testDummyForPit = new TestDummyForPit();
        //when
        int result = testDummyForPit.returnJUnitParams(input);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    public Object[] getTestInputValues() {
        return $(
                $(1, 1),
                $(2, 2),
                $(3, 3)
        );
    }
}