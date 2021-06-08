package io.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class ExceptionServiceTest {

    @Test
    public void testHappyPath() {

        // 1
        // create test context
        ExceptionService service = new ExceptionService();

        // 1
        // 1.1
        // create input data
        int x = 1;
        int y = 2;

        // 1.2
        // create expected result
        int expectedResult = 3;

        // 2
        // 2.1 invoke to be tested method
        // 2.2 and collect result
        int actualResult = service.complexBusiness(x, y);

        // 3
        // verify expectations
        // 3.1
        // verify I/O expectations
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test(expected = RuntimeException.class)
    public void testSpecialCaseFirstParameterNegative() {

        // 1
        // create test context
        ExceptionService service = new ExceptionService();

        // 1
        // 1.1
        // create input data
        int x = -1;
        int y = 2;

        // 1.2
        // create expected result

        // 2
        // 2.1 invoke to be tested method
        // 2.2 and collect result
        try {
            service.complexBusiness(x, y);
        } catch (Exception e) {

            // 3
            // verify expectations
            Assert.assertEquals("Negative parameter", e.getMessage());

            // 3.1
            // verify I/O expectations

            throw e;
        }

        Assert.fail("expected exception not raised");

    }

    @Test(expected = RuntimeException.class)
    public void testSpecialCaseSecondParameterNegative() {

        // 1
        // create test context
        ExceptionService service = new ExceptionService();

        // 1
        // 1.1
        // create input data
        int x = 1;
        int y = -2;

        // 1.2
        // create expected result

        // 2
        // 2.1 invoke to be tested method
        // 2.2 and collect result
        try {
            service.complexBusiness(x, y);
        } catch (Exception e) {

            // 3
            // verify expectations
            Assert.assertEquals("Negative parameter", e.getMessage());
            throw e;

            // 3.1
            // verify I/O expectations

        }

        Assert.fail("expected exception not raised");

    }
}
