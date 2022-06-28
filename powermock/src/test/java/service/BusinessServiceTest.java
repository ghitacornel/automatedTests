package service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest(BusinessService.class)
public class BusinessServiceTest {

    BusinessService businessService = new BusinessService();

    @Test
    public void testBusinessMethod() throws Exception {

        when(businessService, "privateMethod", "in").thenReturn("mockedResult");

        String input = "in";

        String result = businessService.businessMethod(input);

        Assert.assertEquals(input + input + input + input, result);
    }
}
