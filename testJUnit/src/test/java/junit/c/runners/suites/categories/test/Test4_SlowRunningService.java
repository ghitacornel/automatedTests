package junit.c.runners.suites.categories.test;

import junit.c.runners.suites.categories.ServiceWithMultipleTypesOfMethods;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Test4_SlowRunningService {

    @Category(OddCategory.class)
    @Test
    public void test1_SlowRunningFlow7() {
        new ServiceWithMultipleTypesOfMethods().slowRunningBusiness();
    }

    @Category(EvenCategory.class)
    @Test
    public void test2_SlowRunningFlow8() {
        new ServiceWithMultipleTypesOfMethods().slowRunningBusiness();
    }

}
