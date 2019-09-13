package unitils.injections;

import org.junit.Assert;
import org.junit.Test;
import org.unitils.inject.util.InjectionUtils;
import unitils.service.ServiceWithInjections;

/**
 * no need to extend special class<br>
 * for me is the simplest way to inject
 */
public class ServiceWithInjections4SimpleTest {

    private ServiceWithInjections service = new ServiceWithInjections();

    @Test
    public void test() {

        // simple inject
        InjectionUtils.injectInto(9, service, "presetInjectedValue");
        Assert.assertEquals(12, service.sum(3));

        // static inject
        InjectionUtils.injectIntoStatic(11, ServiceWithInjections.class, "presetStaticValue");
        Assert.assertEquals(14, ServiceWithInjections.staticSum(3));

        // and search the documentation for other kind of injections.
    }

}
