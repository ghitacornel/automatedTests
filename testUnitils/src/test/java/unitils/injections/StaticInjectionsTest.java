package unitils.injections;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.inject.annotation.InjectIntoStaticByType;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class StaticInjectionsTest {
    /**
     * this annotation will inject by type this value in this static field<br>
     * it is possible also to use an injection by property name but injection by
     * type saves us specifying the property name when we now for sure one field
     * of that type is present in class<br>
     * this time we need to specify which class is affected<br>
     * Unitils will revert the injected value to the original one once test is     * completed
     */
    @InjectIntoStaticByType(target = ServiceWithInjections.class)
    private int valueToBeInjectedIntoStatic = 11;

    @Test
    public void test() {
        Assert.assertEquals(14, ServiceWithInjections.staticSum(3));
    }

}
