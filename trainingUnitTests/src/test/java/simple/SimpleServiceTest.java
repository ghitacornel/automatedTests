package simple;

import org.junit.Assert;
import org.junit.Test;

public class SimpleServiceTest {

    // https://en.wikipedia.org/wiki/Unit_testing
    // we test 1 method in isolation which is achieved using mocks when needed
    // we test 1 method in isolation which means is forbidden for sharing test contexts
    // OBSERVE : I don't need to think/understand what the code is supposed to do
    // OBSERVE : I assume the code does what is supposed to do
    // OBSERVE : I write the unit test to ensure that the actual code does what is meant to do now
    // OBSERVE : This way I protect it from further "accidental" changes
    // OBSERVE : That's why unit tests are written best at the same time with the code
    // OBSERVE : TDD tells us to write tests first then the code, sometimes this is difficult but achievable
    // IF IT IS HARD TO WRITE A UNIT TEST THEN THE PROBLEM IS NOT THE UNIT TEST, THE PROBLEM LIES IN THE DESIGN OF THE CODE
    @Test
    public void simpleBusinessMethod() {

        // step 1 = GIVEN
        // create test context
        // DO NOT SHARE test context for UNIT tests
        // test context is usually shared for Integration tests
        SimpleService simpleService = new SimpleService();

        // step 1 - create input data
        int a = 1;
        int b = 2;

        // step 1 - create expected output data
        // usually this is the last part of step 1 due to dependency of input data
        int expectedResult = a + b;

        // step 2 = WHEN
        // invoke
        // collect return if available
        int actualResult = simpleService.simpleBusinessMethod(a, b);

        // step 3 = THEN
        // validate

        // step 3 - validate expected output vs actual output
        Assert.assertEquals(expectedResult, actualResult);

    }

    // give meaningful name when testing specific execution path (not like this one)
    @Test
    public void businessMethodWithMultipleExecutionPaths_PATH_1() {

        // step 1 = GIVEN
        // create test context
        SimpleService simpleService = new SimpleService();

        // step 1 - create input data
        int x = 1;

        // step 1 - create expected output data
        int expectedResult = x;

        // step 2 = WHEN
        // invoke
        // collect return if available
        int actualResult = simpleService.businessMethodWithMultipleExecutionPaths(x);

        // step 3 = THEN
        // validate

        // step 3 - validate expected output vs actual output
        Assert.assertEquals(expectedResult, actualResult);

    }

    // give meaningful name when testing specific execution path (not like this one)
    @Test
    public void businessMethodWithMultipleExecutionPaths_PATH_2() {

        // step 1 = GIVEN
        // create test context
        SimpleService simpleService = new SimpleService();

        // step 1 - create input data
        int x = -1;

        // step 1 - create expected output data
        int expectedResult = -x;

        // step 2 = WHEN
        // invoke
        // collect return if available
        int actualResult = simpleService.businessMethodWithMultipleExecutionPaths(x);

        // step 3 = THEN
        // validate

        // step 3 - validate expected output vs actual output
        Assert.assertEquals(expectedResult, actualResult);

    }

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
        SimpleService simpleService = new SimpleService();

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
        SimpleService simpleService = new SimpleService();

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
            // for exceptions need to verify exception type and exception message/content
            Assert.assertSame(RuntimeException.class, e.getClass());
            Assert.assertEquals(message, e.getMessage());

        }

    }

    // sometimes provided input data is also part of the output
    @Test
    public void businessMethodThatAltersInputData() {

        // step 1 = GIVEN
        // create test context
        SimpleService simpleService = new SimpleService();

        // step 1 - create input data
        InputData inputData = new InputData();
        int initialInputDataX = 10;
        inputData.setX(initialInputDataX);

        // step 1 - create expected output data

        // step 2 = WHEN
        // invoke
        // collect return if available
        simpleService.businessMethodThatAltersInputData(inputData);

        // step 3 = THEN
        // validate

        // step 3 - validate expected output vs actual output
        // in this case output is part of the provided input
        Assert.assertEquals(initialInputDataX + 1, inputData.getX());

    }
}
