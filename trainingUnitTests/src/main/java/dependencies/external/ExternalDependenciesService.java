package dependencies.external;

// managed by a IoC container
public class ExternalDependenciesService {

    private ExternalDependency1 dependency1;// injected
    private ExternalDependency2 dependency2;// injected

    public int complexBusiness(int x, int y) {
        dependency1.validate(x, y);
        if (x < 10 || y < 10) {
            return dependency2.calculateSpecific(x, y);
        }
        return x + y;
    }

}
