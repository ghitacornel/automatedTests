package junit.a.simple.test;

import org.junit.Test;

/**
 * A method annotated with {@link Test} is considered by JUnit as a single
 * unique test<br>
 * You can have multiple {@link Test} annotated methods defined in a single test
 * class<br>
 * JUnit will run each test on a different test class instance. In other words
 * each test will run on its very own test class instance, not shared by other
 * tests<br>
 * Usually a test class will contain many related test methods
 * Remember Java Reflection !!!
 */
public class ImplementationServiceTest2MultipleTests {

    /**
     * these 2 tests will show that JUnit will run each test method on a
     * different test class instance
     */
    @Test
    public void test1() {
        System.out.println("running on " + this);
    }

    @Test
    public void test2() {
        System.out.println("running on " + this);
    }

}
