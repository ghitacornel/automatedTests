package simple3;

import org.junit.Assert;
import org.junit.Test;

public class SimpleServiceTest {

    // give meaningful name when testing specific execution path (not like this one)
    @Test
    public void businessMethodWithExceptions_PATH_1() {

        // step 1 = GIVEN
        // create test context
        SimpleService simpleService = new SimpleService();

        // step 1 - create input data
        int x = 0;

        // step 1 - create expected output data
        int expectedResult = 1;

        // step 2 = WHEN
        // invoke
        // collect return if available
        int actualResult = simpleService.businessMethodWithExceptions(x);

        // step 3 = THEN
        // validate

        // step 3 - validate expected output vs actual output
        Assert.assertEquals(expectedResult, actualResult);

    }

    // give meaningful name when testing specific execution path (not like this one)
    @Test
    public void businessMethodWithExceptions_PATH_2() {

        // step 1 = GIVEN
        // create test context
        simple.SimpleService simpleService = new simple.SimpleService();

        // step 1 - create input data
        int x = 3;

        // step 1 - create expected output data
        int expectedResult = 6;

        // step 2 = WHEN
        // invoke
        // collect return if available
        int actualResult = simpleService.businessMethodWithExceptions(x);

        // step 3 = THEN
        // validate

        // step 3 - validate expected output vs actual output
        Assert.assertEquals(expectedResult, actualResult);

    }

    // give meaningful name when testing specific execution path (not like this one)
    // when testing for exceptions check the test framework functionalities
    // when testing for exceptions check the exception class but also the exception content
    @Test
    public void businessMethodWithExceptions_PATH_Exception() {

        // step 1 = GIVEN
        // create test context
        simple.SimpleService simpleService = new simple.SimpleService();

        // step 1 - create input data
        int x = -1;

        // step 1 - create expected output data
        String message = "negative value";

        // step 2 = WHEN
        // invoke
        // collect return if available
        // this time the return is an exception
        try {
            simpleService.businessMethodWithExceptions(x);
            Assert.fail("expected exception");
        } catch (Exception e) {

            // step 3 = THEN
            // validate

            // step 3 - validate expected output vs actual output
            // for exceptions need to verify exception type
            Assert.assertSame(RuntimeException.class, e.getClass());
            // for exceptions need to verify exception message/content
            Assert.assertEquals(message, e.getMessage());

        }

    }

}
