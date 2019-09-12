package junit.cases.exceptions;

import junit.cases.exceptions.ComplexService;

import org.junit.Test;

public class ComplexServiceTest4_Exceptions {

    /**
     * good practice : if method throws exceptions for certain parameter values
     * try to create scenarios for testing the throwing of such exceptions, take
     * into account each parameter or combination of parameters<br>
     * good practice : document why these tests were written and what business
     * decision is tested, they can be linked to bug tracking issues<br>
     * try to have 1 test per each work flow that throws an exception<br>
     * try to have 1 test per each application exception, even when not tied to
     * a special work flow<br>
     * <p>
     * Note that we don't care exception message, but only its type<br>
     * Usually this is enough assuming a business exception is not used with
     * different messages
     *
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void testBusinessSumAException() throws Exception {
        new ComplexService().complexBusinessMethod(-1, 2);
    }

    @Test(expected = Exception.class)
    public void testBusinessSumBException() throws Exception {
        new ComplexService().complexBusinessMethod(1, -2);
    }

    @Test(expected = Exception.class)
    public void testBusinessSumABException() throws Exception {
        new ComplexService().complexBusinessMethod(-1, -2);
    }

}
