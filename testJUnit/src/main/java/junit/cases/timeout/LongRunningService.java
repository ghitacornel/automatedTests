package junit.cases.timeout;

public class LongRunningService {

    /**
     * this is a time consuming very complex business method
     */
    public void timeConsumingBusinessOperation() {

        try {

            // ensure this method takes a "long time"
            Thread.sleep(100);

        } catch (Exception e) {

            // for simplicity of the test ignore exceptions
            e.printStackTrace();

        }
    }

}
