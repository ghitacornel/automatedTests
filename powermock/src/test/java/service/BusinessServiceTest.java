package service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.powermock.api.mockito.PowerMockito.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest(BusinessService.class)
public class BusinessServiceTest {

    @Test
    public void testBusinessMethodMockingPrivateMethod() throws Exception {
        BusinessService businessService = spy(new BusinessService());

        when(businessService, "privateMethod", "in").thenReturn("mockedResult");

        String input = "in";

        String result = businessService.businessMethod(input);

        Assert.assertEquals("inmockedResult", result);
        verifyPrivate(businessService).invoke("privateMethod", "in");
    }

    @Test
    public void testPrivateMethod() throws Exception {
        BusinessService businessService = new BusinessService();
        Object result = Whitebox.invokeMethod(businessService, "privateMethod", "in");
        Assert.assertEquals("ininin", result);
    }
}
