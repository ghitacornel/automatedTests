package junit.e.assumptions.test;

import junit.e.assumptions.ServiceNotFullyImplemented;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

/**
 * use assumptions for writing tests that will be run when certain external constraints are met<br>
 * e.g. tests are executed under certain environment (linux/windows)<br>
 * e.g. some tests must be executed only for some certain external configuration settings ( environment variables )
 * while other tests must not be executed for same configuration settings
 */
public class ServiceNotFullyImplementedTest {

    @Test
    public void testMultiply() {

        // assumption fails => test is ignored
        // assumption passes => test is executed
        {
            try {
                // just make dummy call to see if this method was implemented
                new ServiceNotFullyImplemented().multiply(1, 1);
            } catch (UnsupportedOperationException e) {

                // if this exception was raised => ignore this test
                Assume.assumeNoException(e);

            }
        }

        // the work in progress in our service will no longer stop us
        // writing our test.
        // we can mock the work in progress and write the test but use
        // assumptions for enabling them.
        // a better mocking framework will be presented later.

        Assert.assertEquals(6, new ServiceNotFullyImplemented().multiply(2, 3));

    }
}
