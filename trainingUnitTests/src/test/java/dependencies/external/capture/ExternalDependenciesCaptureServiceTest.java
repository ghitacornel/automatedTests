package dependencies.external.capture;

import dependencies.external.ClassWithExternalDependency1;
import dependencies.external.ClassWithExternalDependency2;
import dependencies.external.ExternalDependenciesService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ExternalDependenciesCaptureServiceTest {

    @InjectMocks
    ExternalDependenciesCaptureService service = new ExternalDependenciesCaptureService();

    @Mock
    ClassWithExternalDependency mock;

    @Captor
    ArgumentCaptor<String> message1;

    @Captor
    ArgumentCaptor<String> message;

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
        Assert.assertEquals(expectedResult, actualResult);

        // 3.2
        // verify mocking interaction
        Mockito.verify(mock, Mockito.times(2)).notify(message.capture());
        List<String> expectedMessages = List.of("first parameter 11", "second parameter 22");
        Assert.assertEquals(expectedMessages, message.getAllValues());

    }


}
