package junit.cases.exceptions;

import junit.cases.exceptions.ComplexService;
import junit.cases.exceptions.CustomBusinessException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ComplexServiceTest5_ExceptionsWithMessages {

    /**
     * this is something 'special'<br>
     * check JUnit documentation for {@link Rule} usage<br>
     * rules acts like a context holder which can be checked by the framework on
     * test completion or just provide setup support
     */
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * test for exception type and exception message
     *
     * @throws Exception
     */
    @Test
    public void testCustomBusinessException() throws Exception {

        // define in the rule the expected exception type
        expectedException.expect(CustomBusinessException.class);
        // define in the rule the expected exception message
        expectedException.expectMessage("custom business exception");

        new ComplexService().complexBusinessMethod(-3, -4);
    }

    /**
     * run these 2 tests to prove that JUNit creates a {@link Rule} for each test
     */
    @Test
    public void test1() {
        System.out.println(expectedException);
    }

    @Test
    public void test2() {
        System.out.println(expectedException);
    }

}
