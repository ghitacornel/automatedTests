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

    // OBSERVE private methods are tested through the exposed business method
    // OBSERVE private methods add testing complexity to the exposed business method
    // in some cases PARAMETERS MATRIX based I/O can be used => Parameterised tests

}
