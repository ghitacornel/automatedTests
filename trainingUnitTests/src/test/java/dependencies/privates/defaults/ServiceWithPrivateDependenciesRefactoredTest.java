package dependencies.privates.defaults;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceWithPrivateDependenciesRefactoredTest {

    @InjectMocks
    @Spy
    ServiceWithPrivateDependenciesRefactored service;

    @Test
    public void testHappyPath() {

        // 1
        // create test context

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
        verify(service).complexBusiness(x, y);
        verify(service).validate(x, y);
        verifyNoMoreInteractions(service);
    }

    @Test
    public void testValidationFails() {

        // 1
        // create test context

        // 1
        // 1.1
        // create input data
        int x = 11;
        int y = 22;

        // 1.2
        // mock parts of the spied object
        doThrow(IllegalArgumentException.class).when(service).validate(x, y);

        // 2
        // 2.1 invoke to be tested method
        // 2.2 and collect result
        assertThrows(IllegalArgumentException.class, () -> service.complexBusiness(x, y));

        // 3
        // verify expectations

    }

    @Test
    public void testSpecialCaseFirstParameterLessThan10() {

        // 1
        // create test context

        // 1
        // 1.1
        // create input data
        int x = 8;
        int y = 10;

        // 1.2
        // create expected result
        int expectedResult = -10;

        // mock parts of the spied object
        doReturn(expectedResult).when(service).calculateSpecific(x, y);

        // 2
        // 2.1 invoke to be tested method
        // 2.2 and collect result
        int actualResult = service.complexBusiness(x, y);

        // 3
        // verify expectations
        // 3.1
        // verify I/O expectations
        assertEquals(expectedResult, actualResult);
        verify(service).complexBusiness(x, y);
        verify(service).validate(x, y);
        verify(service).calculateSpecific(x, y);
        verifyNoMoreInteractions(service);

    }

    @Test
    public void testSpecialCaseSecondParameterLessThan10() {

        // 1
        // create test context

        // 1
        // 1.1
        // create input data
        int x = 10;
        int y = 8;

        // 1.2
        // create expected result
        int expectedResult = -10;
        // mock parts of the spied object
        doReturn(expectedResult).when(service).calculateSpecific(x, y);


        // 2
        // 2.1 invoke to be tested method
        // 2.2 and collect result
        int actualResult = service.complexBusiness(x, y);

        // 3
        // verify expectations
        // 3.1
        // verify I/O expectations
        assertEquals(expectedResult, actualResult);
        verify(service).complexBusiness(x, y);
        verify(service).validate(x, y);
        verify(service).calculateSpecific(x, y);
        verifyNoMoreInteractions(service);

    }

    // test "default"ed dependencies separately
    @Test
    public void calculateSpecific() {
        assertEquals(3, service.calculateSpecific(2, 4));
    }

    // test "default"ed dependencies separately
    @Test
    public void validateFirstNegative() {
        assertThrows(IllegalArgumentException.class, () -> service.complexBusiness(-10, 10));
    }

    // test "default"ed dependencies separately
    @Test
    public void validateSecondNegative() {
        assertThrows(IllegalArgumentException.class, () -> service.complexBusiness(10, -10));
    }

}
