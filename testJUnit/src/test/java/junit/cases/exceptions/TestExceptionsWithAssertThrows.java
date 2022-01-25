package junit.cases.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class TestExceptionsWithAssertThrows {

    @Test
    public void testCustomBusinessException() {

        Assert.assertThrows(CustomBusinessException.class, () -> new ComplexService().complexBusinessMethod(-3, -4));

    }
}
