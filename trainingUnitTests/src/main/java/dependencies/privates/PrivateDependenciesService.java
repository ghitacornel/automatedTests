package dependencies.privates;

public class PrivateDependenciesService {

    public int complexBusiness(int x, int y) {
        validate(x, y);
        if (x < 10 || y < 10) return calculateSpecific(x, y);
        return x + y;
    }

    private void validate(int x, int y) {
        if (x < 0 || y < 0) throw new RuntimeException("Negative parameter");
    }

    private int calculateSpecific(int x, int y) {
        return (x + y) / 2;
    }

    // PRIVATE methods "DO NOT EXIST"
    // hence we are not allowed to unit test them
    // even if we could use reflection for invoking them
    // testing them means acknowledging their existence and leaving no room for further transparent changes

    // OBSERVE private methods are tested through the exposed business methods that use them
    // OBSERVE private methods become part of the exposed business methods that use them
    // OBSERVE private methods add testing complexity to the exposed business methods that use them
    // in some cases PARAMETERS MATRIX based I/O can be used => Parameterised tests

    // in order to make possible unit testing of such private methods
    // we can use the following approach
    // 1. mark these private methods with default visibility
    // 2. move these private methods to helper/companion/utility classes
    // 3. mark encapsulating helper/companion/utility classes with default visibility
    // 4. writing unit tests in classes defined in same package as encapsulating helper/companion/utility classes

}
