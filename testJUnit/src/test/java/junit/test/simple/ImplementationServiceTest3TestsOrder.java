package junit.test.simple;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Order of test executions must be irrelevant<br>
 * Order of test executions can be controlled<br>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
// try playing with different method order
public class ImplementationServiceTest3TestsOrder {

    @Test
    public void test3() {
    }

    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

}
