package nou;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AggregatorServiceTest {

    @InjectMocks
    AggregatorService aggregatorService = new AggregatorService();

    @Mock
    BusinessService1 mock1;

    @Mock
    BusinessService2 mock2;

    @Mock
    BusinessService3 mock3;

    @Test
    public void testAggregatorService() {

        aggregatorService.businessMethod();

        // verify mocks were used in the proper order
        InOrder order = Mockito.inOrder(mock1, mock2, mock3);

        order.verify(mock1).businessMethod1();
        order.verify(mock2).businessMethod2();
        order.verify(mock3).businessMethod3();
        order.verifyNoMoreInteractions();

    }
}
