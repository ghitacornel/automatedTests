package unitils.injections;

import org.junit.Assert;
import org.junit.Test;
import org.unitils.inject.util.InjectionUtils;

/**
 * manual injection
 */
public class ManualInjectionsTest {

    private ServiceWithInjections service = new ServiceWithInjections();

    @Test
    public void test() {

        // simple inject
        InjectionUtils.injectInto(9, service, "presetInjectedValue");
        Assert.assertEquals(12, service.sum(3));

        // static inject
        InjectionUtils.injectIntoStatic(11, ServiceWithInjections.class, "presetStaticValue");
        Assert.assertEquals(14, ServiceWithInjections.staticSum(3));

        // TODO and search the documentation for other kind of injections.

    }

}
