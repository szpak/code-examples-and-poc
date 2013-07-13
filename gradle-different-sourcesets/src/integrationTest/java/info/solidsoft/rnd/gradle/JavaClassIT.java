package info.solidsoft.rnd.gradle;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaClassIT {

    private static final int TEST_VALUE = 2;

    @Test
    public void shouldReturnGivenValueInIntegration() {
        JavaClass javaClass = new JavaClass();

        int returnedValue = javaClass.returnInputValue(TEST_VALUE);

        assertThat(returnedValue).isEqualTo(TEST_VALUE);
    }

}
