package info.solidsoft.rnd.pit.spock;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class TestDummyForPitParametrizedTestNGTest {

    @Test(dataProvider = "testInputValues")
    public void shouldGenerateCoverageForParametrizedTestNG(int input, int expectedResult) {
        //given
        TestDummyForPit testDummyForPit = new TestDummyForPit();
        //when
        int result = testDummyForPit.returnParametrizedTestNG(input);
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @DataProvider(name = "testInputValues")
    public Object[][] getTestInputValues() {
        return new Object[][] {
                {1, 1},
                {2, 2},
                {3, 3}
        };
    }
}
