package dependencies.external;

public class ExternalDependenciesService {

    // hint => @Autowired by container
    private ClassWithExternalDependency1 classWithExternalDependency1;

    // hint => @Autowired by container
    private ClassWithExternalDependency2 classWithExternalDependency2;

    public int complexBusiness(int x, int y) {
        classWithExternalDependency1.validate(x, y);
        if (x < 10 || y < 10) {
            return classWithExternalDependency2.calculateSpecific(x, y);
        }
        return x + y;
    }

    // OBSERVE private methods were extracted to external dependencies
    // OBSERVE extracted private methods are no more tested through the exposed business method
    // OBSERVE extracted private methods do not add that much testing complexity to the exposed business method

}
