package junit.lifecycle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AbstractTest {

    @BeforeClass
    public static void beforeAllTestsParent() {
        System.out.println("run before all tests from parent");
    }

    @Before
    public void beforeEachTestParent() {
        System.out.println("run before each test from parent on instance " + this);
    }

    @After
    public void afterEachTestParent() {
        System.out.println("run after each test from parent on instance " + this);
    }

    @AfterClass
    public static void afterAllTestsParent() {
        System.out.println("run after all tests from parent");
    }

}
