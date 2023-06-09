package dependencies.external;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExternalDependenciesServiceTest {

    // no need to create it manually
    // Mockito inject @Mock fields without the need of an IoC container
    @InjectMocks
    ExternalDependenciesService service;

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
        Assert.assertEquals(expectedResult, actualResult);

        // 3.2
        // verify mocking interaction
        // since it is only 1 mock interacted with, no need to use an InOrder check
        Mockito.verify(mock1).validate(x, y);

    }


    @Test(expected = RuntimeException.class)
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
        Mockito.doThrow(new RuntimeException("mock exception")).when(mock1).validate(x, y);

        // 2
        // 2.1 invoke to be tested method
        // 2.2 and collect result
        try {
            service.complexBusiness(x, y);
        } catch (Exception e) {

            // 3
            // verify expectations
            Assert.assertEquals("mock exception", e.getMessage());

            // 3.1
            // verify I/O expectations

            // 3.2
            // verify mocking interaction
            Mockito.verify(mock1).validate(x, y);
            throw e;

        }

        Assert.fail("expected exception not raised");

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
        Mockito.when(mock2.calculateSpecific(x, y)).thenReturn(5);

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
        // verify mocking interaction when more than 1 mock is involved
        // - no not forget to test for mock invocation order
        InOrder order = Mockito.inOrder(mock1, mock2);
        order.verify(mock1).validate(x, y);
        order.verify(mock2).calculateSpecific(x, y);
        // - no not forget to test for no more interactions
        order.verifyNoMoreInteractions();

    }

}
