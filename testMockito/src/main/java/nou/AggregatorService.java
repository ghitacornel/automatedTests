package nou;

public class AggregatorService {

    // assume injected
    // implementation is provided at runtime
    private BusinessService1 businessService1;

    // assume injected or created by constructor
    private BusinessService2 businessService2 = new BusinessService2();

    // assume injected
    private BusinessService3 businessService3 = new BusinessService3Implementation();

    public void businessMethod() {

        // create test context
        InputData inputData = new InputData();

        businessService1.businessMethod1();
        businessService2.businessMethod2();
        businessService3.businessMethod3();

    }

}
