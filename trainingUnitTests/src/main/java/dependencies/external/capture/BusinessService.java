package dependencies.external.capture;

// managed by a IoC container
public class BusinessService {

    private ExternalDependency externalDependency;// injected

    public int complexBusiness(int x, int y) {
        externalDependency.notify("first parameter " + x);
        externalDependency.notify("second parameter " + y);
        return x + y;
    }

    // OBSERVE external dependency called multiple times with dynamically calculated argument

}
