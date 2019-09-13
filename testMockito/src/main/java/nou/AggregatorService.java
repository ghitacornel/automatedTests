package nou;

public class AggregatorService {

    // assume injected
    // implementation is provided at runtime
    private BusinessService1 businessService1;

    // assume injected or created by constructor
    private BusinessService2 businessService2 = new BusinessService2();

    // assume injected
    private BusinessService3 businessService3 = new BusinessService3Implementation();

    public OutputData businessMethod(InputData inputData) {

        // use first service
        businessService1.businessMethod1(inputData);

        // use second service
        OutputData outputData = businessService2.businessMethod2(inputData);

        // use third service
        businessService3.businessMethod3();

        return outputData;

    }

}
