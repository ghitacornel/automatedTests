package junit.b.setup.test;

import junit.b.setup.ServiceWithRunningContext;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * sometimes the test context is hard to build and can be reused across
 * different test methods<br>
 * JUnit comes with a flavor of context 'listeners'
 */
public class ServiceTest extends AbstractTest {

    /**
     * we want to test on the same service instance across many test scenarios
     * due to hard to build test context
     */
    private static ServiceWithRunningContext service;

    /**
     * called once before all test defined in this class are executed<br>
     * NOTE that this method has to be static
     */
    @BeforeClass
    public static void beforeAllTestsAreExecuted() {

        System.out.println("setup before all tests are executed");

        // since a service instance is hard to create => we will create one
        // instance of service + and we will reuse it across all tests performed
        // in this class
        service = new ServiceWithRunningContext();

    }

    /**
     * called once after all tests defined in this class were executed<br>
     * NOTE that this method has to be static
     */
    @AfterClass
    public static void afterAllTestsWereExecuted() {

        // since one instance of service was used across all tests performed in
        // this class at the end of all tests we will have to destroy it
        service.destroy();

        System.out.println("setup after all tests were executed");

    }

    /**
     * called once before each test
     */
    @Before
    public void setupBeforeEachTest() {

        // since calls to service methods change its inner state we will have to
        // reset it before each test
        service.reset();
        System.out.println("set up before each test, reset context = "
                + service);

    }

    /**
     * called once after each test
     */
    @After
    public void setupAfterEachTest() {

        // since calls to service methods change its inner state and some
        // expensive resources can be left open we might have to reset/close
        // them after each test
        System.out
                .println("set up after each test, reset context = " + service);
        service.reset();

    }

    @Test
    public void testImportantBusiness() throws Exception {
        Assert.assertEquals(0, service.getState());
        service.importantBusiness();
        Assert.assertEquals(2, service.getState());
    }

    @Test
    public void testVeryImportantBusiness() throws Exception {
        Assert.assertEquals(0, service.getState());
        service.veryImportantBusiness();
        Assert.assertEquals(5, service.getState());
    }

    /**
     * sometimes a test method will test an entire work flow<br>
     * if test context changes across methods invocation we will have to use
     * multiple asserts at different steps performed in the same test method<br>
     */
    @Test
    public void testWorkFlow() {

        Assert.assertEquals(0, service.getState());

        // work flow step 1
        {

            // use the context at this step
            service.importantBusiness();

            // expect context changed and changes are those expected
            Assert.assertEquals(2, service.getState());

        }

        // work flow step 2
        {

            // again use the same changed context in this next step
            service.veryImportantBusiness();

            // expect context changed again and new changes are those expected
            Assert.assertEquals(7, service.getState());

        }

        // ... other steps and asserts

    }

}
