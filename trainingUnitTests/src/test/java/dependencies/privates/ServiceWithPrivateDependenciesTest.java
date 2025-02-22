package dependencies.privates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceWithPrivateDependenciesTest {

    @Test
    public void testHappyPath() {

        // 1
        // create test context
        ServiceWithPrivateDependencies service = new ServiceWithPrivateDependencies();

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
        assertEquals(expectedResult, actualResult);

    }


    @Test
    public void testSpecialCaseFirstParameterNegative() {

        // 1
        // create test context
        ServiceWithPrivateDependencies service = new ServiceWithPrivateDependencies();

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
        Exception e = assertThrows(RuntimeException.class, () -> service.complexBusiness(x, y));
        assertEquals("Negative parameter", e.getMessage());

        // 3
        // verify expectations
        // 3.1
        // verify I/O expectations

    }

    @Test
    public void testSpecialCaseSecondParameterNegative() {

        // 1
        // create test context
        ServiceWithPrivateDependencies service = new ServiceWithPrivateDependencies();

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
        Exception e = assertThrows(RuntimeException.class, () -> service.complexBusiness(x, y));
        assertEquals("Negative parameter", e.getMessage());

        // 3
        // verify expectations
        // 3.1
        // verify I/O expectations

    }


    @Test
    public void testSpecialCaseFirstParameterLessThan10() {

        // 1
        // create test context
        ServiceWithPrivateDependencies service = new ServiceWithPrivateDependencies();

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
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testSpecialCaseSecondParameterLessThan10() {

        // 1
        // create test context
        ServiceWithPrivateDependencies service = new ServiceWithPrivateDependencies();

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
        assertEquals(expectedResult, actualResult);

    }
}
