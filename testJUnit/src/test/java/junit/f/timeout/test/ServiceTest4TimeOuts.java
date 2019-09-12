package junit.f.timeout.test;

import junit.f.longrunning.ServiceF;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * tests with timeouts can be used to test algorithms for efficiency
 * 
 * @author Cornel
 * 
 */
public class ServiceTest4TimeOuts {

	/**
	 * it is even possible to set timeouts<br>
	 * see JUnit documentation related to time {@link Rule} and {@link Timeout}
	 */
	@Test(timeout = 200)
	public void testTimeConsumingBusinessOperation() {
		new ServiceF().timeConsumingBusinessOperation();
	}

	/**
	 * this test will fail<br>
	 * timeout expectation will not be achieved<br>
	 * this annotation is useful for example when testing algorithms or time
	 * critical applications (:D beware of garbage collector and HotSpot
	 * optimizations)
	 */
	@Test(timeout = 50)
	public void testTimeConsumingBusinessOperationThatWillFail() {
		new ServiceF().timeConsumingBusinessOperation();
	}
}
