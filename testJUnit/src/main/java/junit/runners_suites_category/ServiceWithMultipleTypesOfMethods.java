package junit.runners_suites_category;

public class ServiceWithMultipleTypesOfMethods {

    /**
     * assume fast to execute business
     */
    public void fastRunningBusiness() {
    }

    /**
     * assume slow to execute business; maybe makes calls to a database or web
     * service, etc.
     */
    public void slowRunningBusiness() {
    }

}
