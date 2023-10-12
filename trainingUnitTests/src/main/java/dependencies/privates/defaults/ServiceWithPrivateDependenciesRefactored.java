package dependencies.privates.defaults;

public class ServiceWithPrivateDependenciesRefactored {

    // complex business method that delegates to private methods
    public int complexBusiness(int x, int y) {
        validate(x, y);
        if (x < 10 || y < 10) return calculateSpecific(x, y);
        return x + y;
    }

    // old PRIVATE dependencies are marked now as DEFAULT
    // a generic practice is to move them to a "Helper" class
    // "Helper" class => class that has name equal to the helped class + suffix "Helper"
    // "Helper" class => class that is declared in the same package with the helped class
    // "Helper" class => class that is marked as DEFAULT + FINAL
    // "Helper" class => class that has all its methods DEFAULT
    // "Helper" class => class that will be injected in the helped class (preferred approach) or can contain only static methods
    void validate(int x, int y) {
        if (x < 0 || y < 0) throw new IllegalArgumentException("Negative parameter");
    }

    int calculateSpecific(int x, int y) {
        return (x + y) / 2;
    }

}
