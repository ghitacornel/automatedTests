package dependencies.external.capture;

// managed by a IoC container
public class BusinessService {

    private ExternalDependency1 externalDependency1;// injected
    private ExternalDependency2 externalDependency2;// injected

    public int complexBusiness(int x, int y) {
        ValueDto valueDto = new ValueDto();
        valueDto.x = x;
        valueDto.y = y;
        x = externalDependency1.execute(valueDto);
        externalDependency2.notify("first parameter " + x);
        externalDependency2.notify("second parameter " + y);
        return x + y;
    }

    // OBSERVE external dependency called multiple times with dynamically calculated argument

}
