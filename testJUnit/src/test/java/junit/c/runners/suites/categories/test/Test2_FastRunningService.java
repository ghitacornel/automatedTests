package junit.c.runners.suites.categories.test;

import junit.c.runners.suites.categories.ServiceWithMultipleTypesOfMethods;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Test2_FastRunningService {

    @Category(OddCategory.class)
    @Test
    public void test1_FastRunningFlow3() {
        new ServiceWithMultipleTypesOfMethods().fastRunningBusiness();
    }

    @Category(EvenCategory.class)
    @Test
    public void test2_FastRunningFlow4() {
        new ServiceWithMultipleTypesOfMethods().fastRunningBusiness();
    }

}
