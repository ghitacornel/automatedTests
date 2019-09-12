package junit.a.simple.test;

import junit.a.simple.ImplementationService;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ImplementationServiceTest4AssertFailIgnored {

    /**
     * this is another test for expectations using assert keyword<br>
     * surprisingly though the assert is wrong the test will pass when running
     * with eclipse plug-in<br>
     * by default java 'assert' are disabled and need to be manually enabled
     * hence this behavior<br>
     * that's why even it seems easier I do not recommend them
     */
    @Test
    public void testCanUseJavaAssertKeywordForDefiningTestExpectations() {
        assert new ImplementationService().sum(4, 5) == 19 : "test fail";
    }

    /**
     * this test will intentionally fail<br>
     * it is placed here to see some test fail results and to see that custom
     * error messages are displayed
     */
    @Test
    public void testCanMarkTestAsFailForSpecificContext() {

        {
            // if test reach this step then consider this test as fail
            // make this test fail with the specified message
            // useful when defining complex expectations
            Assert.fail("this test must fail if this step is reached");
        }

    }

    /**
     * you can mark a test as to be ignored<br>
     * it is placed here to see that custom messages are displayed for these
     * tests<br>
     * to be used for incomplete or failed tests as a quick and DIRTY fix for
     * passing the continuous integration tests but don't forget to fix them
     * ASAP
     */
    @Test
    @Ignore("this test is intentionally disabled")
    public void testCanMarkTestAsIgnored() {

        // test for negative values
        // TODO i'm too lazy today :D , will do it tomorrow
        // TODO this test failed again !!! , i'm too lazy to fix it

    }

}
