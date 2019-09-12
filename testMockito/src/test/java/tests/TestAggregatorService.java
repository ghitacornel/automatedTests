package tests;

import mockito.services.AggregatorService;
import mockito.services.Service1;
import mockito.services.Service2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestAggregatorService {

    @InjectMocks
    AggregatorService aggregatorService = new AggregatorService();

    @Mock
    Service1 mock1;

    @Mock
    Service2 mock2;

    @Before
    public void before() {
        Mockito.when(mock1.complexBusiness("inputString")).thenReturn("inputStringinputString");
        Mockito.when(mock2.complexBusiness(1)).thenReturn(2);
    }

    @After
    public void after() {
        Mockito.verifyNoMoreInteractions(mock1, mock2);
    }

    @Test
    public void testAggregatorService() {

        String inputString = "inputString";
        Integer inputInteger = 1;

        String result = aggregatorService.complexBusiness(inputString, inputInteger);

        Assert.assertEquals("inputStringinputString and 2", result);

        // verify mocks were used in the proper order
        InOrder order = Mockito.inOrder(mock1, mock2);
        order.verify(mock1).complexBusiness("inputString");
        order.verify(mock2).complexBusiness(1);
        order.verifyNoMoreInteractions();

    }
}
