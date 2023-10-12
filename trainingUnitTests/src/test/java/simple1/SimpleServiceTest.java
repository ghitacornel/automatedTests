package simple1;

import org.junit.Assert;
import org.junit.Test;

public class SimpleServiceTest {

    // https://en.wikipedia.org/wiki/Unit_testing
    // we test 1 method in isolation which is achieved using mocks when needed
    // we test 1 method in isolation which means sharing test contexts is forbidden
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
        SimpleService service = new SimpleService();

        // step 1 - create input data
        int a = 1;
        int b = 2;

        // step 1 - create expected output data
        // usually this is the last part of step 1 due to dependency of input data
        int expectedResult = a + b;

        // step 2 = WHEN
        // invoke
        // collect return if available
        int actualResult = service.simpleBusinessMethod(a, b);

        // step 3 = THEN
        // validate

        // step 3 - validate expected output vs actual output
        Assert.assertEquals(expectedResult, actualResult);

    }

}
