package dependencies.external;

// managed by a IoC container
class ServiceWithExternalDependencies {

    private final ExternalDependency1 externalDependency1;// injected
    private final ExternalDependency2 externalDependency2;// injected

    ServiceWithExternalDependencies(ExternalDependency1 externalDependency1, ExternalDependency2 externalDependency2) {
        this.externalDependency1 = externalDependency1;
        this.externalDependency2 = externalDependency2;
    }

    public int complexBusiness(int x, int y) {
        externalDependency1.validate(x, y);
        if (x < 10 || y < 10) {
            return externalDependency2.calculateSpecific(x, y);
        }
        return x + y;
    }

}
