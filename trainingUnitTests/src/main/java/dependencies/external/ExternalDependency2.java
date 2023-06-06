package dependencies.external;

// managed by a IoC container
class ExternalDependency2 {

    public int calculateSpecific(int x, int y) {
        return (x + y) / 2;
    }

}
