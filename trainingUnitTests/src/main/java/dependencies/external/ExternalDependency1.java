package dependencies.external;

// hint => @Service
class ExternalDependency1 {

    public void validate(int x, int y) {
        if (x < 0 || y < 0) throw new RuntimeException("Negative parameter");
    }

}
