package tests;

import model.Model;
import org.junit.Assert;
import org.junit.Test;
import service.MyService;

public class TestMyService {

    @Test
    public void testChangeModel() {

        Model model = new Model();
        model.setId(1);
        model.setName("nume");

        MyService myService = new MyService();

        String value = myService.changeModel(model);

        Assert.assertEquals(model.getName(), value);
        Assert.assertEquals(new Integer(2), model.getId());
    }

    @Test
    public void testSum() {

        MyService myService = new MyService();

        int value = myService.sum(1, 2);

        Assert.assertEquals(3, value);
    }

    @Test(expected = RuntimeException.class)
    public void testSumException() {

        MyService myService = new MyService();
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

        MyService myService = new MyService();
        try {
            myService.sum(0, 2);
        } catch (Exception e) {
            Assert.assertEquals("zero values detected", e.getMessage());
            throw e;
        }

        Assert.fail("must not reach this");
    }
}
