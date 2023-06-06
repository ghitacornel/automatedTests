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

    // OBSERVE private methods are tested through the exposed business methods that use them
    // OBSERVE private methods become part of the exposed business methods that use them
    // OBSERVE private methods add testing complexity to the exposed business methods that use them
    // in some cases PARAMETERS MATRIX based I/O can be used => Parameterised tests

    // in order to make possible unit testing of such private methods
    // we can use the approach of having these private methods made default
    // and moved to default helper/companion/utility classes

}
