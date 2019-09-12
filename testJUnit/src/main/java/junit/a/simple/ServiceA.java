package junit.a.simple;

/**
 * See that this service implements a contract(interface)<br>
 * We want to test that this service honors its contract<br>
 * 
 * @author CornelGhita
 * 
 */
public class ServiceA implements IService {

	@Override
	public int sum(int a, int b) {
		internalStuff();
		return a + b;
	}

	/**
	 * private methods are not to be tested<br>
	 * we test that our public methods which implements a contract really honor
	 * their contracts (in other words they implement what the interface says)<br>
	 * WHY WE TEST ONLY PUBLIC METHODS IS A DIFFERENT TOPIC NOT DISCUSSED NOW
	 */
	private void internalStuff() {
	}

}
