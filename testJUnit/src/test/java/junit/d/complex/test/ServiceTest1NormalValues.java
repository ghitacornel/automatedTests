package junit.d.complex.test;

import junit.d.complex.ServiceD;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTest1NormalValues {

    /**
     * good practice : test all work flows for working 'normal' input values
     *
     * @throws Exception
     */
    @Test
    public void testBusinessSum() throws Exception {
        Assert.assertEquals(3, new ServiceD().businessSum(1, 2));
    }

}
