package junit.cases.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ComplexServiceTest6_ExceptionsRule {

    /**
     * a rule for checking exceptions
     */
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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
