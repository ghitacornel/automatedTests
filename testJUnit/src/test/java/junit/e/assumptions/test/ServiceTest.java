package junit.e.assumptions.test;

import junit.e.assumptions.ServiceE;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class ServiceTest {

    @Test
    public void testMultiply() {

        // We can use assumptions for writing tests that will be run
        // when certain external constraints are met.

        // assumption fails => test is ignored
        // assumption passes => test is executed
        {
            try {
                // just make dummy call to see if this method was implemented
                new ServiceE().multiply(1, 1);
            } catch (UnsupportedOperationException e) {
                // this exception was raised => ignore this test
                Assume.assumeNoException(e);
            }
        }

        // the work in progress in our service will no longer stop us
        // writing our test.
        // we can mock the work in progress and write the test but use
        // assumptions for enabling them.
        // a better mocking framework will be presented later.

        Assert.assertEquals(6, new ServiceE().multiply(2, 3));

    }
}
