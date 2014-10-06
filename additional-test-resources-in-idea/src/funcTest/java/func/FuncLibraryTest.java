package func;

import base.Library;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FuncLibraryTest {
    @Test public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
}
