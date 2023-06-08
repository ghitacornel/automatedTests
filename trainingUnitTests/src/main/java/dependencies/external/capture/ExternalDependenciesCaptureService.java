package dependencies.external.capture;

// managed by a IoC container
public class ExternalDependenciesCaptureService {

    // hint => @Autowired by container
    private ClassWithExternalDependency classWithExternalDependency;// injected

    public int complexBusiness(int x, int y) {
        classWithExternalDependency.notify("first parameter " + x);
        classWithExternalDependency.notify("second parameter " + y);
        return x + y;
    }

    // OBSERVE external dependency called multiple times with dynamically calculated argument

}
