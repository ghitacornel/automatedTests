package junit.simple;

/**
 * See that this service implements a contract(interface)<br>
 * We want to test that this service honors its contract<br>
 */
public class ImplementationService implements InterfaceService {

    @Override
    public int sum(int a, int b) {
        internalStuff();
        return a + b;
    }

    /**
     * private methods are not to be tested<br>
     * private methods hide implementation details and are subject to change, but public methods must honor the contract<br>
     * we test that our public methods which implements a contract really honor
     * their contracts (in other words they implement what the interface says)<br>
     */
    private void internalStuff() {
    }

}
