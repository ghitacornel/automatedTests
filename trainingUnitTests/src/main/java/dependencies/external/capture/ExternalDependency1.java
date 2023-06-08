package dependencies.external.capture;

// managed by a IoC container
public class ExternalDependency1 {

    public int execute(ValueDto valueDto) {
        return valueDto.x * valueDto.y;
    }

}
