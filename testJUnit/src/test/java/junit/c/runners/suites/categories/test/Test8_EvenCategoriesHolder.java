package junit.c.runners.suites.categories.test;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(EvenCategory.class)
@SuiteClasses({
        Test1_FastRunningService.class,
        Test2_FastRunningService.class,
        Test3_SlowRunningService.class,
        Test4_SlowRunningService.class
})
public class Test8_EvenCategoriesHolder {

    // similar to suites but restrictive to a certain category

    // still need to specify which classes to target

    // but specify now a certain category of tests

    // only tests annotated marked as even will be executed

}
