package junit.d.complex.test;

import junit.cases.exceptions.ComplexService;

import org.junit.Assert;
import org.junit.Test;

public class ComplexServiceTest1_NormalValues {

    /**
     * good practice : test all work flows for working 'normal' input values
     *
     * @throws Exception
     */
    @Test
    public void testBusinessSum() throws Exception {
        Assert.assertEquals(3, new ComplexService().complexBusinessMethod(1, 2));
    }

}
