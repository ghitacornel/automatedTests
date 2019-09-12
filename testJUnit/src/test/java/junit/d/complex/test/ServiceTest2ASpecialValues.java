package junit.d.complex.test;

import junit.d.complex.ServiceD;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTest2ASpecialValues {

    /**
     * good practice : special values for method parameters require special test
     * scenarios, take into account each parameter or combination of parameters<br>
     * good practice : document why these tests were written and what business
     * decision is tested, they can be linked to bug tracking issues<br>
     * special input values will result in special output values, and will NOT
     * raise exceptions; you can see them as acceptable but uncommon input
     * values which do not follow the common business<br>
     *
     * @throws Exception
     */
    @Test
    public void testBusinessSumSpecialValue() throws Exception {
        Assert.assertEquals(-1, new ServiceD().businessSum(0, 2));
        Assert.assertEquals(-1, new ServiceD().businessSum(1, 0));
        Assert.assertEquals(-1, new ServiceD().businessSum(0, 0));
    }

}
