package unitils.assertions;

import org.junit.Assert;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.reflectionassert.ReflectionComparatorMode;
import unitils.model.User;
import unitils.service.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceAssertionsTest {

    /**
     * this test will fail<br>
     * {@link User} does not implement equals
     */
    @Test
    public void test1AssertionsUsingJUnitAssert() {

        User expected = new User(1, "John", "Doe");

        // use business and transform model
        User actual = new Service().getCurrentBusinessUser();

        // test expectations
        Assert.assertEquals(expected, actual);

    }

    /**
     * solution to the failing test is to manually test each part of the model
     */
    @Test
    public void test2AssertionsUsingJUnitAssertOnPartsOfModel() {

        User expected = new User(1, "John", "Doe");

        // use business and transform model
        User actual = new Service().getCurrentBusinessUser();

        // test expectations
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getFirst(), actual.getFirst());
        Assert.assertEquals(expected.getLast(), actual.getLast());

    }

    /**
     * a better solution is using Unitils reflection asserts
     */
    @Test
    public void test3AssertionsUsingUnitilsReflection() {

        User expected = new User(1, "John", "Doe");

        // use business and transform model
        User actual = new Service().getCurrentBusinessUser();

        // test expectations
        // very useful for complex model
        ReflectionAssert.assertReflectionEquals(expected, actual);

        // or more specific :
        // test a certain property for having a certain value using reflection.
        // This kind of tests allow testing internals of a class and that's
        // somehow odd but might help in testing inner details of complex
        // algorithms or frameworks not available for external usage.
        // again public exposed behavior should be tested and not inner details.
        ReflectionAssert.assertPropertyLenientEquals("id", 1, actual);

    }

    @Test
    public void test4AssertionsUsingUnitilsReflectionLenient() {

        // expected users in no particular order
        List<User> expectedUsers = new ArrayList<>();
        expectedUsers.add(new User(3, "John3", "Doe3"));
        expectedUsers.add(new User(1, "John1", "Doe1"));
        expectedUsers.add(new User(2, "John2", "Doe2"));

        // use business and transform model
        List<User> actualUsers = new Service()
                .getCurrentBusinessUsers();

        // test expectations
        // use lenient order since order of elements is not important.
        // there are many variants of lenient.
        ReflectionAssert.assertReflectionEquals(expectedUsers, actualUsers,
                ReflectionComparatorMode.LENIENT_ORDER);

        // or some other odd stuff
        // here test only id property values from the collection
        ReflectionAssert.assertPropertyLenientEquals("id",
                Arrays.asList(1, 2, 3), actualUsers);

    }
}
