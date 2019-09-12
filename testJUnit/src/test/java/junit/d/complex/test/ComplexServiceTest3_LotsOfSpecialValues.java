package junit.d.complex.test;

import java.util.Arrays;
import java.util.Collection;

import junit.cases.exceptions.ComplexService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * when testing with lots of different input values and expectations you can use
 * {@link RunWith} {@link Parameterized}<br>
 * remember runners ?
 */
@RunWith(Parameterized.class)
public class ComplexServiceTest3_LotsOfSpecialValues {

    /**
     * input bean for each test
     */
    public static class InputModel {

        int a, b;

        InputModel(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }

    /**
     * @return all input and expected output as pairs (input,output) => useful for defining a decision matrix
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new InputModel(0, 1), -1},
                {new InputModel(1, 0), -1},
                {new InputModel(0, 0), -1}
        });
    }

    // this filed will be injected for each test
    // it needs to be public, no worry since these are only tests
    // XXX don't know why they force you to keep it public
    @Parameter(value = 0)
    public InputModel input;

    // this filed will be injected for each test
    // it needs to be public, no worry since these are only tests
    // XXX don't know why they force you to keep it public
    @Parameter(value = 1)
    public int output;

    /**
     * this example shows a unified way of running tests for special input
     * values
     *
     * @throws Exception
     */
    @Test
    public void testBusinessSumSpecialValue() throws Exception {
        Assert.assertEquals(output, new ComplexService().complexBusinessMethod(input.a, input.b));
    }

}
