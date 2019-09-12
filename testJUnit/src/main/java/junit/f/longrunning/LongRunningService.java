package junit.f.longrunning;

public class LongRunningService {

    /**
     * this is a time consuming very complex business method
     *
     * @throws Exception
     */
    public void timeConsumingBusinessOperation() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // for simplicity of the test ignore exceptions
        }
    }

}
