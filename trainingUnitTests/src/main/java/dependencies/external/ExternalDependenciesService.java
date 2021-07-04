package dependencies.external;

// hint => @Service
public class ExternalDependenciesService {

    // hint => @Autowired of field by container
    private ClassWithExternalDependency1 dependency1;

    // hint => @Autowired of field by container
    private ClassWithExternalDependency2 dependency2;

    public int complexBusiness(int x, int y) {
        dependency1.validate(x, y);
        if (x < 10 || y < 10) {
            return dependency2.calculateSpecific(x, y);
        }
        return x + y;
    }

    // OBSERVE private methods were extracted to external dependencies
    // OBSERVE extracted private methods are no more tested through the exposed business method
    // OBSERVE extracted private methods do not add that much testing complexity to the exposed business method

}
