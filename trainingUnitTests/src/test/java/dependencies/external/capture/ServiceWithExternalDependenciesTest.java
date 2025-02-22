package dependencies.external.capture;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceWithExternalDependenciesTest {

    // no need to create it manually
    // Mockito inject @Mock fields without the need of an IoC container
    @InjectMocks
    ServiceWithExternalDependencies service;

    @Mock
    ExternalDependency1 externalDependency1;

    @Captor
    ArgumentCaptor<ValueDto> valueDtoArgumentCaptor;

    @Mock
    ExternalDependency2 externalDependency2;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

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
        // create mocking context
        // create mocks / create mocks input data / create mocks output data / define mocks behavior
        int externalDependencyResult = -100;
        when(externalDependency1.execute(valueDtoArgumentCaptor.capture())).thenReturn(externalDependencyResult);

        // 1.3
        // create expected result
        int expectedResult = y + externalDependencyResult;

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
        InOrder inOrder = inOrder(externalDependency1, externalDependency2);
        inOrder.verify(externalDependency1).execute(valueDtoArgumentCaptor.getValue());
        inOrder.verify(externalDependency2, Mockito.times(2)).notify(stringArgumentCaptor.capture());
        inOrder.verifyNoMoreInteractions();

        // 3.3
        // verify captured data
        List<String> expectedMessages = List.of("first parameter 11", "second parameter 22");
        assertEquals(expectedMessages, stringArgumentCaptor.getAllValues());

        assertEquals(x, valueDtoArgumentCaptor.getValue().x);
        assertEquals(y, valueDtoArgumentCaptor.getValue().y);

    }


}
