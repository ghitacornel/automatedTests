package junit.a.simple.test;

import junit.a.simple.IService;
import junit.a.simple.ServiceA;

import org.junit.Assert;
import org.junit.Test;

/**
 * by convention if we test a single class using a single test class then test
 * class name should be = [simple class to test name] + 'Test'<br>
 * by convention test classes should be placed in same packages as the tested
 * classes but different folders<br>
 * MAVEN tool for example enforces a clear separation between source code and
 * automated tests and also a clear naming convention<br>
 * it is useful to comment test class to detail what class is tested and others<br>
 * Observe that test class execution order is and must be irrelevant<br>
 * 
 * @author CornelGhita
 * 
 */
public class ServiceTest1Single {

	/**
	 * XXX this is how your test probably look if done manually<br>
	 * No framework is used
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if (new ServiceA().sum(1, 2) != 3) {
			throw new RuntimeException(" test fail");
		} else {
			System.out.println("test passed");
		}
	}

	/**
	 * by convention test class method names should start with 'test'<br>
	 * by convention test class method names should hint to what method is
	 * tested<br>
	 * by convention private methods are not to be tested, we test what the
	 * class exposes and nothing more<br>
	 * a simple {@link Test} annotation on a method tells JUnit the class is a
	 * test class<br>
	 * each @Test annotated method is seen by JUnit as a single automated test
	 */
	@Test
	public void testSum() {

		// create a test context for our test.
		// building it can be very hard sometimes.
		IService service = new ServiceA();

		// run a test scenario over the test context
		int sum = service.sum(1, 2);

		// test for expectations using Assert mini framework.
		// check the many 'assert' static methods defined here.
		// if assert fails then exception is raised.
		// static methods can be statically imported.
		// see HAMCREST as matching framework.
		// more powerful matching frameworks will be detailed further
		Assert.assertEquals(3, sum);

	}

}
