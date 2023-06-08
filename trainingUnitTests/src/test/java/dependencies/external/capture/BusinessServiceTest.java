package dependencies.external.capture;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BusinessServiceTest {

    @InjectMocks
    BusinessService service = new BusinessService();

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
        // create expected result
        int expectedResult = -78;

        // 1.3
        // create mocking context
        // create mocks / create mocks input data / create mocks output data / define mocks behavior
        Mockito.when(externalDependency1.execute(valueDtoArgumentCaptor.capture())).thenReturn(-100);

        // 2
        // 2.1 invoke to be tested method
        // 2.2 and collect result
        int actualResult = service.complexBusiness(x, y);

        // 3
        // verify expectations

        // 3.1

        // verify I/O expectations
        Assert.assertEquals(expectedResult, actualResult);

        // 3.2
        // verify mocking interaction
        InOrder inOrder = Mockito.inOrder(externalDependency1, externalDependency2);
        inOrder.verify(externalDependency1).execute(valueDtoArgumentCaptor.getValue());
        inOrder.verify(externalDependency2, Mockito.times(2)).notify(stringArgumentCaptor.capture());
        inOrder.verifyNoMoreInteractions();

        // 3.3
        // verify captured data
        List<String> expectedMessages = List.of("first parameter -100", "second parameter 22");
        Assert.assertEquals(expectedMessages, stringArgumentCaptor.getAllValues());

        Assert.assertEquals(x, valueDtoArgumentCaptor.getValue().x);
        Assert.assertEquals(y, valueDtoArgumentCaptor.getValue().y);

    }


}
