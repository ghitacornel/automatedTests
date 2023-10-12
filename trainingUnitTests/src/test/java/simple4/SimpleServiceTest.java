package simple4;

import org.junit.Assert;
import org.junit.Test;

public class SimpleServiceTest {

    // sometimes provided input data is also part of the output
    @Test
    public void businessMethodThatAltersInputData() {

        // step 1 = GIVEN
        // create test context
        SimpleService simpleService = new SimpleService();

        // step 1 - create input data
        InputData inputData = new InputData();
        int initialInputDataX = 10;
        inputData.x = initialInputDataX;

        // step 1 - create expected output data

        // step 2 = WHEN
        // invoke
        // collect return if available
        simpleService.businessMethodThatAltersInputData(inputData);

        // step 3 = THEN
        // validate

        // step 3 - validate expected output vs actual output
        // in this case output is part of the provided input
        Assert.assertEquals(initialInputDataX + 1, inputData.x);

    }
}
