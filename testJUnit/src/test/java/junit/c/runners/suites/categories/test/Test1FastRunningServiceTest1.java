package junit.c.runners.suites.categories.test;

import junit.c.runners.suites.categories.ServiceC;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Test1FastRunningServiceTest1 {

    @Category(OddCategory.class)
    @Test
    public void test1fastRunningFlow1() {
        new ServiceC().fastRunningBusiness();
    }

    @Category(EvenCategory.class)
    @Test
    public void test2fastRunningFlow2() {
        new ServiceC().fastRunningBusiness();
    }

}
