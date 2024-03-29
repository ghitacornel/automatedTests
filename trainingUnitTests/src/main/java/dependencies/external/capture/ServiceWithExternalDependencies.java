package dependencies.external.capture;

// managed by a IoC container
class ServiceWithExternalDependencies {

    private final ExternalDependency1 externalDependency1;// injected
    private final ExternalDependency2 externalDependency2;// injected

    ServiceWithExternalDependencies(ExternalDependency1 externalDependency1, ExternalDependency2 externalDependency2) {
        this.externalDependency1 = externalDependency1;
        this.externalDependency2 = externalDependency2;
    }

    // OBSERVE external dependency 1 called once with dynamically calculated argument
    // OBSERVE external dependency 2 called multiple times with dynamically calculated argument
    public int complexBusiness(int x, int y) {
        ValueDto valueDto = new ValueDto();
        valueDto.x = x;
        valueDto.y = y;
        int q = externalDependency1.execute(valueDto);
        externalDependency2.notify("first parameter " + x);
        externalDependency2.notify("second parameter " + y);
        return q + y;
    }

}
