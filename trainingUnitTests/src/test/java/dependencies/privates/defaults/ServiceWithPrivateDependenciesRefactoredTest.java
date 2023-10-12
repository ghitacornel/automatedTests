package dependencies.privates.defaults;

import org.junit.Assert;
import org.junit.Test;

public class ServiceWithPrivateDependenciesRefactoredTest {

    @Test
    public void testHappyPath() {

        // 1
        // create test context
        ServiceWithPrivateDependenciesRefactored service = new ServiceWithPrivateDependenciesRefactored();

        // 1
        // 1.1
        // create input data
        int x = 11;
        int y = 22;

        // 1.2
        // create expected result
        int expectedResult = 33;

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
        ServiceWithPrivateDependenciesRefactored service = new ServiceWithPrivateDependenciesRefactored();

        // 1
        // 1.2
        // create input data
        int x = -1;
        int y = 2;

        // 1.1
        // create expected result

        // 2
        // 2.1 invoke to be tested method
        // 2.2 and collect result
        try {
            service.complexBusiness(x, y);
        } catch (Exception e) {
            Assert.assertEquals("Negative parameter", e.getMessage());
            throw e;
        }

        // 3
        // verify expectations
        // 3.1
        // verify I/O expectations

    }

    @Test(expected = RuntimeException.class)
    public void testSpecialCaseSecondParameterNegative() {

        // 1
        // create test context
        ServiceWithPrivateDependenciesRefactored service = new ServiceWithPrivateDependenciesRefactored();

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
            Assert.assertEquals("Negative parameter", e.getMessage());
            throw e;
        }

        // 3
        // verify expectations
        // 3.1
        // verify I/O expectations

    }


    @Test
    public void testSpecialCaseFirstParameterLessThan10() {

        // 1
        // create test context
        ServiceWithPrivateDependenciesRefactored service = new ServiceWithPrivateDependenciesRefactored();

        // 1
        // 1.1
        // create input data
        int x = 8;
        int y = 10;

        // 1.2
        // create expected result
        int expectedResult = 9;

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
    public void testSpecialCaseSecondParameterLessThan10() {

        // 1
        // create test context
        ServiceWithPrivateDependenciesRefactored service = new ServiceWithPrivateDependenciesRefactored();

        // 1
        // 1.1
        // create input data
        int x = 10;
        int y = 8;

        // 1.2
        // create expected result
        int expectedResult = 9;

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
