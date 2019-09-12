package junit.f.timeout.test;

import junit.f.longrunning.LongRunningService;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * tests with timeouts can be used to test algorithms for efficiency<br>
 * it is possible to set timeouts for tests<br>
 */
public class LongRunningServiceTest4Timeouts {

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
