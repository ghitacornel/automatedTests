package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BusinessServiceTest {

    BusinessService businessService = new BusinessService();

    @Test
    public void testBusinessMethod() {
        String input = "in";

        String result = businessService.businessMethod(input);

        Assertions.assertEquals(input + input + input + input, result);
    }
}
