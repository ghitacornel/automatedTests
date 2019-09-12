package junit.cases.timeout;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * it is possible to set timeouts for tests<br>
 * tests with timeouts can be used to test algorithms for efficiency<br>
 */
public class LongRunningServiceTest_Timeouts {

    /**
     * see JUnit documentation related to time {@link Rule} and {@link Timeout}
     */
    @Test(timeout = 200)
    public void testTimeConsumingBusinessOperation_SUCCESS() {
        new LongRunningService().timeConsumingBusinessOperation();
    }

    /**
     * this test will fail<br>
     * timeout expectation will not be achieved
     */
    @Test(timeout = 50)
    public void testTimeConsumingBusinessOperation_TIMEOUT_FAIL() {
        new LongRunningService().timeConsumingBusinessOperation();
    }
}
