package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import service.MyService;
import service.ValidationService;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class TestMyServiceMockito {

    @InjectMocks
    MyService myService = new MyService();

    @Mock
    ValidationService validationService;

    @Test
    public void testSum() {

        int value = myService.sum(1, 2);

        Assert.assertEquals(3, value);

        Mockito.verify(validationService).validate(1, 2);
        Mockito.verifyNoMoreInteractions(validationService);
    }

    @Test(expected = RuntimeException.class)
    public void testSumException() {

        try {
            myService.sum(-1, 2);
        } catch (Exception e) {
            Assert.assertEquals("negative values detected", e.getMessage());
            throw e;
        }

        Assert.fail("must not reach this");
    }

    @Test(expected = RuntimeException.class)
    public void testSumExceptionZero() {

        try {
            myService.sum(0, 2);
        } catch (Exception e) {
            Assert.assertEquals("zero values detected", e.getMessage());
            throw e;
        }

        Assert.fail("must not reach this");
    }
}
