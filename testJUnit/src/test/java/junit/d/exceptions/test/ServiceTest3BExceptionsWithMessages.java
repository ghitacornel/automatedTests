package junit.d.exceptions.test;

import junit.d.complex.ServiceD;
import junit.d.complex.VerySpecialBusinessException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ServiceTest3BExceptionsWithMessages {

    /**
     * this is something 'special'<br>
     * check JUnit documentation for {@link Rule} usage<br>
     * rules acts like a context holder which can be checked by the framework on
     * test completion or just provide setup support
     */
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /**
     * TEST FOR exception type AND exception message !!!
     *
     * @throws Exception
     */
    @Test
    public void testVerySpecialBusinessStuff() throws Exception {
        expectedException.expect(VerySpecialBusinessException.class);
        expectedException.expectMessage("very special business exception");
        new ServiceD().businessSum(-3, -4);
    }

    /**
     * run these 2 tests to prove that JUNit creates a {@link Rule} for each
     * test
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
