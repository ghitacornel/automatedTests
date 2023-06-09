package dependencies.external;

// managed by a IoC container
class ExternalDependency1 {

    // no need to be public as long as is accessible
    void validate(int x, int y) {
        if (x < 0 || y < 0) throw new RuntimeException("Negative parameter");
    }

}
