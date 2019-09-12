package junit.c.runners.suites.categories.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        Test1_FastRunningService.class,
        Test2_FastRunningService.class
})
public class Test5_FastTestsHolder {

    // class that acts as a holder.
    // it binds fast tests together.

    // note the run with annotation => specify which runner will be used
    // there are lots of specialized runners

    // run with annotation makes class eligible for running with JUnit even
    // though it doesn't declare test methods

    // this method will not be run
    // XXX odd enough
    @Test
    public void test_AllFastRunningService() {

    }

}
