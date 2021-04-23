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
        System.out.println(TestSetup.class.getCanonicalName() + " before all tests are executed from parent");
    }

    /**
     * called once after all tests defined in this class were executed<br>
     * NOTE that this method has to be static
     * NOTE that this method is not invoked in a test classes hierarchy context
     * NOTE OOP => static is not related to inheritance
     */
    @AfterClass
    public static void afterAllTestsWereExecuted() {
        System.out.println(TestSetup.class.getCanonicalName() + " after all tests were executed from parent");
    }

    /**
     * called once before each test<br>
     * better mark it final in order of not to be overridden by mistake<br>
     * NOTE that this method is invoked in a test classes hierarchy context
     */
    @Before
    final public void setupBeforeEachTestParent() {
        System.out.println(this + " before each test from parent");
    }

    /**
     * called once after each test<br>
     * better mark it final in order of not to be overridden by mistake<br>
     * NOTE that this method is invoked in a test classes hierarchy context
     */
    @After
    final public void setupAfterEachTestParent() {
        System.out.println(this + " after each test from parent");
    }

}
