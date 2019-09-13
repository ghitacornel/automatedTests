package junit.test.runner_suite_category;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(OddCategory.class)
@SuiteClasses({
        Test1_FastRunningService.class,
        Test2_FastRunningService.class,
        Test3_SlowRunningService.class,
        Test4_SlowRunningService.class
})
public class Test7_OddCategoriesHolder {

    // similar to suites but restrictive to a certain category

    // still need to specify which classes to target

    // but specify now a certain category of tests

    // only tests annotated marked as odd will be executed

}
