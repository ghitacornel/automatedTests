package io.special;

import org.junit.Assert;
import org.junit.Test;

public class SpecialCaseServiceTest {

    @Test
    public void testHappyPath() {

        // 1
        // create test context
        SpecialCaseService service = new SpecialCaseService();

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

    @Test
    public void testHappyFlowSpecialCaseFirstParameterNegative() {

        // 1
        // create test context
        SpecialCaseService service = new SpecialCaseService();

        // 1
        // 1.1
        // create input data
        int x = -1;
        int y = 2;

        // 1.2
        // create expected result
        int expectedResult = 0;

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

    @Test
    public void testHappyFlowSpecialCaseSecondParameterNegative() {

        // 1
        // create test context
        SpecialCaseService service = new SpecialCaseService();

        // 1
        // 1.1
        // create input data
        int x = 1;
        int y = -2;

        // 1.2
        // create expected result
        int expectedResult = 0;

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
}
