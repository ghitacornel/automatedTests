package dependencies.external;

// managed by a IoC container
class ExternalDependency2 {

    // no need to be public as long as is accessible
    int calculateSpecific(int x, int y) {
        return (x + y) / 2;
    }

}
