package junit.c.runners.suites.categories.test;

import junit.c.runners.suites.categories.ServiceC;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Test4SlowRunningServiceTest4 {

    @Category(OddCategory.class)
    @Test
    public void test1slowRunningFlow7() {
        new ServiceC().slowRunningBusiness();
    }

    @Category(EvenCategory.class)
    @Test
    public void test2slowRunningFlow8() {
        new ServiceC().slowRunningBusiness();
    }

}
