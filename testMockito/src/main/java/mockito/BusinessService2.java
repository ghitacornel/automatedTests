package mockito;

/**
 * Dependency for {@link AggregatorService}
 */
public class BusinessService2 {

    public OutputData businessMethod2(InputData inputData) {
        OutputData outputData = new OutputData();
        outputData.setY(inputData.getX() * 2);
        return outputData;
    }

}
