package junit.cases.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestExceptionsWithMessages {

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

}
