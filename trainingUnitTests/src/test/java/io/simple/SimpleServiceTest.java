package io.simple;

import org.junit.Assert;
import org.junit.Test;

public class SimpleServiceTest {

    @Test
    public void testOneLiner() {
        Assert.assertEquals(3, new SimpleService().complexBusiness(1, 2));
    }

    @Test
    public void testHappyPath() {

        // 1
        // create test context
        SimpleService service = new SimpleService();

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
}
