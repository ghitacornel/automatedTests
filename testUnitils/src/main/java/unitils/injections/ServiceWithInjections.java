package unitils.injections;

public class ServiceWithInjections {

    /**
     * assume these values are beans/values managed and injected by a container<br>
     * in order to test it we need to inject mocked or dummy values
     */
    private static int presetStaticValue = 3;
    private int presetInjectedValue = 4;

    public static int staticSum(int x) {
        return x + presetStaticValue;
    }

    public int sum(int x) {
        return x + presetInjectedValue;
    }

}
