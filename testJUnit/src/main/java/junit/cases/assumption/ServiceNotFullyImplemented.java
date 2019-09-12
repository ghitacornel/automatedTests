package junit.cases.assumption;

/**
 * incomplete service
 */
public class ServiceNotFullyImplemented {

    public int multiply(int a, int b) {

        // TODO let's just say this method implementation is "work in progress"
        // TODO and for now just throw an exception
        throw new UnsupportedOperationException();

        // try to give an implementation and see if the associated tests will be executed

    }
}
