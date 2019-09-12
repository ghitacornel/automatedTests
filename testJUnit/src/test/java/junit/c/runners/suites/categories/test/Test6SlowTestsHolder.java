package junit.c.runners.suites.categories.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        Test3SlowRunningServiceTest3.class,
        Test4SlowRunningServiceTest4.class
})
public class Test6SlowTestsHolder {

    // class that acts as a holder.
    // it binds slow tests together

    // note the run with annotation => specify which runner will be used =>
    // there are lots of specialized runners

    // run with annotation makes class eligible for running with JUnit even
    // though it doesn't declare test methods

}
