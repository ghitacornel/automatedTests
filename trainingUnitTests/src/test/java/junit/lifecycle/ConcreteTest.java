package junit.lifecycle;

import org.junit.*;

public class ConcreteTest extends AbstractTest {

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("run before all tests");
    }

    @Before
    public void beforeEachTest() {
        System.out.println("run before each test on instance " + this);
    }

    @Test
    public void test1() {
        System.out.println("run test 1 on instance " + this);
    }

    @Test
    public void test2() {
        System.out.println("run test 1 on instance " + this);
    }

    @After
    public void afterEachTest() {
        System.out.println("run after each test on instance " + this);
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("run after all tests");
    }

}
