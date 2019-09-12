package junit.c.runners.suites.categories.test;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(EvenCategory.class)
@SuiteClasses({Test1FastRunningServiceTest1.class,
        Test2FastRunningServiceTest2.class, Test3SlowRunningServiceTest3.class,
        Test4SlowRunningServiceTest4.class})
public class Test8EvenCategoriesHolder {

    // similar to suites but restrictive to a certain category

    // still need to specify which classes to target

    // but specify now a certain category of tests

    // only tests annotated marked as even will be executed

}
