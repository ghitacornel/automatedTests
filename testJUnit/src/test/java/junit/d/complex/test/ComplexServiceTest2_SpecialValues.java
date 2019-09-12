package junit.d.complex.test;

import junit.d.complex.ComplexService;

import org.junit.Assert;
import org.junit.Test;

public class ComplexServiceTest2_SpecialValues {

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
        Assert.assertEquals(-1, new ComplexService().complexBusinessMethod(0, 2));
        Assert.assertEquals(-1, new ComplexService().complexBusinessMethod(1, 0));
        Assert.assertEquals(-1, new ComplexService().complexBusinessMethod(0, 0));
    }

}
