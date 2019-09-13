package junit.test.setup;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class TestSetup {

    /**
     * called once before all tests defined in this class are executed<br>
     * NOTE that this method has to be static
     * NOTE that this method is not invoked in a test classes hierarchy context
     * NOTE OOP => static is not related to inheritance
     */
    @BeforeClass
    public static void beforeAllTestsAreExecuted() {
        System.out.println(TestSetup.class.getCanonicalName() + " before all tests are executed");
    }

    /**
     * called once after all tests defined in this class were executed<br>
     * NOTE that this method has to be static
     * NOTE that this method is not invoked in a test classes hierarchy context
     * NOTE OOP => static is not related to inheritance
     */
    @AfterClass
    public static void afterAllTestsWereExecuted() {
        System.out.println(TestSetup.class.getCanonicalName() + " after all tests were executed");
    }

    /**
     * called once before each test
     * NOTE that this method is invoked in a test classes hierarchy context
     */
    @Before
    public void setupBeforeEachTest() {
        System.out.println(this + " before each test");
    }

    /**
     * called once after each test
     * NOTE that this method is invoked in a test classes hierarchy context
     */
    @After
    public void setupAfterEachTest() {
        System.out.println(this + " after each test");
    }

}
