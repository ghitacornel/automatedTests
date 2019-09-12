package mockito.services;

public class AggregatorService {

    private Service1 service1;

    private Service2 service2;

    /**
     * @param inputString
     * @param inputInteger
     * @return double inputString + " and " + double inputInteger
     */
    public String complexBusiness(String inputString, Integer inputInteger) {

        // step 1
        String output1 = service1.complexBusiness(inputString);

        // step 2
        Integer output2 = service2.complexBusiness(inputInteger);

        // step 3
        return output1 + " and " + output2;
    }

}
