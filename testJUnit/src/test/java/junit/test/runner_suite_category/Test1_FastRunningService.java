package junit.test.runner_suite_category;

import junit.c.runners.suites.categories.ServiceWithMultipleTypesOfMethods;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Test1_FastRunningService {

    @Category(OddCategory.class)
    @Test
    public void test1_FastRunningFlow1() {
        new ServiceWithMultipleTypesOfMethods().fastRunningBusiness();
    }

    @Category(EvenCategory.class)
    @Test
    public void test2_FastRunningFlow2() {
        new ServiceWithMultipleTypesOfMethods().fastRunningBusiness();
    }

}
