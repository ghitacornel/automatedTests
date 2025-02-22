package mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

// special runner must be used when using Mockito
@ExtendWith(MockitoExtension.class)
public class AggregatorServiceTest {

    // this is the targeted test object
    // mocks must be provided and injected by Mockito in this targeted object
    // all object dependencies must be mocked
    @InjectMocks
    AggregatorService aggregatorService = new AggregatorService();

    // this mock must be provided by Mockito
    // this mock must be injected by Mockito in the targeted object
    @Mock
    BusinessService1 mock1;

    // this mock must be provided by Mockito
    // this mock must be injected by Mockito in the targeted object
    // it does not matter this dependency is a concrete class
    @Mock
    BusinessService2 mock2;

    // this mock must be provided by Mockito
    // this mock must be injected by Mockito in the targeted object
    @Mock
    BusinessService3 mock3;

    @Test
    public void testAggregatorService() {

        // STEP 1

        // STEP 1.1
        // create test context
        InputData inputData = new InputData();
        inputData.setX(3);
        OutputData outputData = new OutputData();
        outputData.setY(3);

        // STEP 1.2
        // define mock behavior
        {

            // for mock 1 no need to define a behavior => Mockito is NICE ( no null pointer exceptions are raised )

            // for mock 2 define a behavior
            when(mock2.businessMethod2(inputData)).thenReturn(outputData);

            // for mock 3 no need to define a behavior

        }


        // STEP 2

        // execute to be tested method
        OutputData returnedData = aggregatorService.businessMethod(inputData);


        // STEP 3
        {

            // step 3.1

            // verify expectations in terms of pure JUnit asserts
            {
                assertSame(outputData, returnedData);
            }

            // step 3.2

            // verify mocks expectations
            {

                // verify mock interactions were executed in the expected order
                // verifying mock interactions were executed in the expected order is optional in some cases
                // verifying mock interactions were executed in the expected order is mandatory in some cases
                // see UML sequence diagram
                InOrder order = inOrder(mock1, mock2, mock3);

                // verify mock interactions

                // verify mock 1 interaction
                order.verify(mock1).businessMethod1(inputData); // the actual parameter value is also tested

                // verify mock 2 interaction
                order.verify(mock2).businessMethod2(inputData);// the actual parameter value is also tested

                // verify mock 3 interaction
                ArgumentCaptor<TemporaryData> argument = ArgumentCaptor.forClass(TemporaryData.class);
                order.verify(mock3).businessMethod3(argument.capture());
                assertEquals(3, argument.getValue().getW());

                // verify no other mock interactions occurred
                order.verifyNoMoreInteractions();

            }

        }

    }

    // MOCKITO allows for test of multiple same mock interactions
    // MOCKITO allow for mock reset when reusing mocks
    // usual usage => do not reuse mocks across different test classes
    // usual usage => do reuse mocks across different test methods in same class, but different parameter values

}
