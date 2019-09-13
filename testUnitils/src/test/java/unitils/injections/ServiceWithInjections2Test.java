package unitils.injections;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.unitils.UnitilsJUnit4;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;
import unitils.service.ServiceWithInjections;

/**
 * need to extend special class
 */
public class ServiceWithInjections2Test extends UnitilsJUnit4 {

    /**
     * this annotation will inject by type this value in this static field<br>
     * it is possible also to use an injection by property name but injection by
     * type saves us specifying the property name when we now for sure one field
     * of that type is present in class<br>
     * this time we annotate with {@link TestedOn} the affected test class
     * property<br>
     * Unitils will revert the injected value to the original one once test is
     * completed
     */
    @InjectIntoByType
    private int presetInjectedValue = 10;

    @TestedObject
    private ServiceWithInjections service = new ServiceWithInjections();

    @Test
    public void test() {
        Assert.assertEquals(13, service.sum(3));
    }

}
