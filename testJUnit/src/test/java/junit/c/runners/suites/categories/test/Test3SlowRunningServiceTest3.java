package junit.c.runners.suites.categories.test;

import junit.c.runners.suites.categories.ServiceWithMultipleTypesOfMethods;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Test3SlowRunningServiceTest3 {

    @Category(OddCategory.class)
    @Test
    public void test1slowRunningFlow5() {
        new ServiceWithMultipleTypesOfMethods().slowRunningBusiness();
    }

    @Category(EvenCategory.class)
    @Test
    public void test2slowRunningFlow6() {
        new ServiceWithMultipleTypesOfMethods().slowRunningBusiness();
    }

}
