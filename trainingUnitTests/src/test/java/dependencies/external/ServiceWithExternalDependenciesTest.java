package dependencies.external;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceWithExternalDependenciesTest {

    // no need to create it manually
    // Mockito inject @Mock fields without the need of an IoC container
    @InjectMocks
    ServiceWithExternalDependencies service;

    @Mock
    ExternalDependency1 mock1;

    @Mock
    ExternalDependency2 mock2;

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

        // 1.3
        // create mocking context
        // create mocks / create mocks input data / create mocks output data / define mocks behavior

        // 2
        // 2.1 invoke to be tested method
        // 2.2 and collect result
        int actualResult = service.complexBusiness(x, y);

        // 3
        // verify expectations

        // 3.1
        // verify I/O expectations
        assertEquals(expectedResult, actualResult);

        // 3.2
        // verify mocking interaction
        // since it is only 1 mock interacted with, no need to use an InOrder check
        verify(mock1).validate(x, y);

    }


    @Test
    public void testMock1Exception() {

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

        // 1.3
        // create mocking context
        // create mock return and input data
        // do not create a fully fledged input/output data, only a minimalistic input/ output data model
        doThrow(new RuntimeException("mock exception")).when(mock1).validate(x, y);

        // 2
        // 2.1 invoke to be tested method
        // 2.2 and collect result
        RuntimeException e = assertThrows(RuntimeException.class, () -> service.complexBusiness(x, y));

        // 3
        // verify expectations
        assertEquals("mock exception", e.getMessage());

        // 3.1
        // verify I/O expectations

        // 3.2
        // verify mocking interaction
        verify(mock1).validate(x, y);

    }

    @Test
    public void testHappyPathSpecialCase() {

        // 1
        // create test context

        // 1
        // 1.1
        // create input data
        int x = 9;
        int y = 10;

        // 1.2
        // create expected result
        int expectedResult = 5;

        // 1.3
        // create mocking context
        // for each mock method invocation make sure
        // - mock method invocation behavior is defined
        // - input parameters are defined => x, y
        // - output values are defined => 5
        // do not create a fully fledged input/output data, only a minimalistic input/ output data model
        when(mock2.calculateSpecific(x, y)).thenReturn(5);

        // 2
        // 2.1 invoke to be tested method
        // 2.2 and collect result
        int actualResult = service.complexBusiness(x, y);

        // 3
        // verify expectations

        // 3.1
        // verify I/O expectations
        assertEquals(expectedResult, actualResult);

        // 3.2
        // verify mocking interaction when more than 1 mock is involved
        // - no not forget to test for mock invocation order
        InOrder order = inOrder(mock1, mock2);
        order.verify(mock1).validate(x, y);
        order.verify(mock2).calculateSpecific(x, y);
        // - no not forget to test for no more interactions
        order.verifyNoMoreInteractions();

    }

}
