package junit.c.runners.suites.categories.test;

import junit.c.runners.suites.categories.ServiceC;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Test3SlowRunningServiceTest3 {

    @Category(OddCategory.class)
    @Test
    public void test1slowRunningFlow5() {
        new ServiceC().slowRunningBusiness();
    }

    @Category(EvenCategory.class)
    @Test
    public void test2slowRunningFlow6() {
        new ServiceC().slowRunningBusiness();
    }

}
