package junit.a.simple.test;

import junit.a.simple.InterfaceService;
import junit.a.simple.ImplementationService;

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
 */
public class ImplementationServiceTest1Single {

    /**
     * XXX this is how your test probably look if done manually<br>
     * No framework is used
     *
     * @param args
     */
    public static void main(String[] args) {
        ImplementationService service = new ImplementationService();
        if (service.sum(1, 2) != 3) {
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

        // define test context
        InterfaceService service;
        int parameter1;
        int parameter2;

        {// STEP 1 => create test context

            // create a test context for our test.
            // building it can be very hard sometimes.
            service = new ImplementationService();
            parameter1 = 1;
            parameter2 = 2;

        }

        int result;
        {// STEP 2 => this is the actual test

            // invoke to be tested method over the test context created at step 1
            result = service.sum(parameter1, parameter2);

        }

        {// STEP 3 => validate expectations

            // let JUnit validate expectations using Assert framework
            // if assert fails then JUnit raises exception with proper message and mark the test as fail

            // for now there is a single expectation
            Assert.assertEquals(3, result);

        }

    }

}
