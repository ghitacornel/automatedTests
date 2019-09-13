package junit.test.setup;

import org.junit.*;

/**
 * sometimes a test context is hard to build<br>
 * sometimes the test context and can be reused by different test methods<br>
 * JUnit comes with a flavor of context 'listeners'
 */
public class ServiceTest extends TestSetup {

    /**
     * called once before all test defined in this class are executed<br>
     * NOTE that this method has to be static
     */
    @BeforeClass
    public static void beforeAllTestsAreExecuted() {
        // create test context to be used by all test methods
        System.out.println(ServiceTest.class.getCanonicalName() + " before all tests are executed");
    }

    /**
     * called once after all tests defined in this class were executed<br>
     * NOTE that this method has to be static
     */
    @AfterClass
    public static void afterAllTestsWereExecuted() {
        // destroy test context used by all test methods
        System.out.println(ServiceTest.class.getCanonicalName() + " setup after all tests were executed");
    }

    /**
     * called once before each test
     */
    @Before
    public void setupBeforeEachTest() {
        // create test context for each test method
        System.out.println(this + " set up before each test");
    }

    /**
     * called once after each test
     */
    @After
    public void setupAfterEachTest() {
        // destroy test context created for each test method
        System.out.println(this + " set up after each test");

    }

    @Test
    public void test1() {
        System.out.println("test 1 executed by " + this);
    }

    @Test
    public void test2() {
        System.out.println("test 2 executed by " + this);
    }

}
