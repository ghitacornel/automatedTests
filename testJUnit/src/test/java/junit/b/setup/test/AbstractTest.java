package junit.b.setup.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class AbstractTest {

    @BeforeClass
    public static void beforeAllTestsAreExecuted() {
        System.out.println("abstract setup before all tests are executed");
    }

    /**
     * called once after all tests defined in this class were executed<br>
     * NOTE that this method has to be static
     */
    @AfterClass
    public static void afterAllTestsWereExecuted() {
        System.out.println("abstract setup after all tests were executed");
    }

    /**
     * called once before each test
     */
    @Before
    public void setupBeforeEachTest() {
        System.out.println("abstract set up before each test");
    }

    /**
     * called once after each test
     */
    @After
    public void setupAfterEachTest() {
        System.out.println("abstract set up after each test");

    }

}
