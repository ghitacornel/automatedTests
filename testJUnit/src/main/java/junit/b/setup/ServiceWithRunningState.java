package junit.b.setup;

/**
 * assume instances of this class are hard to create and keep inner state across
 * business service invocations
 *
 * @author CornelGhita
 */
public class ServiceWithRunningState {

    /**
     * state across business service invocations is kept here
     */
    private int state;

    /**
     * assume this is a hard to build class<br>
     * maybe a builder/factory is required in order to obtain instances of this
     * class<br>
     * this constructor is intended only for demo
     */
    public ServiceWithRunningState() {
        state = 0;// very difficult to build state
        System.out.println(this + " created");
    }

    /**
     * assume important business is implemented here<br>
     * assume calls to this method change inner object state
     */
    public void importantBusiness() {

        // important business execution change state of this class
        state += 2;

    }

    /**
     * assume important business is implemented here<br>
     * assume calls to this method change inner object state
     */
    public void veryImportantBusiness() {

        // important business execution change state of this class
        state += 5;

    }

    /**
     * reset the service state<br>
     * if reset the service can be considered as a new one
     */
    public void resetState() {
        state = 0;
    }

    /**
     * destroy this service<br>
     * will close used database connections, file streams and other expensive
     * used resources .....
     */
    public void destroyService() {
        System.out.println(this + " will be destroyed");
    }

    public int getState() {
        return state;
    }

}
