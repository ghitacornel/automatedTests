package dependencies.external.capture;

public class ExternalDependenciesCaptureService {

    // hint => @Autowired by container
    private ClassWithExternalDependency classWithExternalDependency;

    public int complexBusiness(int x, int y) {
        classWithExternalDependency.notify("first parameter " + x);
        classWithExternalDependency.notify("second parameter " + y);
        return x + y;
    }

    // OBSERVE external dependency called multiple times with dynamically calculated argument

}
