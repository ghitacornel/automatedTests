package simple;

import org.junit.Assert;
import org.junit.Test;

public class SimpleServiceTest {

    @Test
    public void simpleBusinessMethod() {

        // step 1 = GIVEN
        // create test context
        SimpleService simpleService = new SimpleService();

        // step 1 - create input data
        int a = 1;
        int b = 2;

        // step 1 - create expected output data
        int expectedResult = 3;

        // step 2 = WHEN
        // invoke
        // collect return if available
        int actualResult = simpleService.simpleBusinessMethod(a, b);

        // step 3 = THEN
        // validate

        // step 3 - validate expected output vs actual output
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void businessMethodWithMultipleExecutionPaths_PATH_1() {

        // step 1 = GIVEN
        // create test context
        SimpleService simpleService = new SimpleService();

        // step 1 - create input data
        int x = 1;

        // step 1 - create expected output data
        int expectedResult = 1;

        // step 2 = WHEN
        // invoke
        // collect return if available
        int actualResult = simpleService.businessMethodWithMultipleExecutionPaths(x);

        // step 3 = THEN
        // validate

        // step 3 - validate expected output vs actual output
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void businessMethodWithMultipleExecutionPaths_PATH_2() {

        // step 1 = GIVEN
        // create test context
        SimpleService simpleService = new SimpleService();

        // step 1 - create input data
        int x = -1;

        // step 1 - create expected output data
        int expectedResult = 1;

        // step 2 = WHEN
        // invoke
        // collect return if available
        int actualResult = simpleService.businessMethodWithMultipleExecutionPaths(x);

        // step 3 = THEN
        // validate

        // step 3 - validate expected output vs actual output
        Assert.assertEquals(expectedResult, actualResult);

    }

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

    @Test
    public void businessMethodThatAltersInputData() {

        // step 1 = GIVEN
        // create test context
        SimpleService simpleService = new SimpleService();

        // step 1 - create input data
        InputData inputData = new InputData();
        inputData.setX(10);

        // step 1 - create expected output data

        // step 2 = WHEN
        // invoke
        // collect return if available
        simpleService.businessMethodThatAltersInputData(inputData);

        // step 3 = THEN
        // validate

        // step 3 - validate expected output vs actual output
        // in this case output is part of the provided input
        Assert.assertEquals(11, inputData.getX());

    }
}
