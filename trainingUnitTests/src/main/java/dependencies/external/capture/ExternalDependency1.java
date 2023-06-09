package dependencies.external.capture;

// managed by a IoC container
class ExternalDependency1 {

    // no need to be public as long as is accessible
    int execute(ValueDto valueDto) {
        return valueDto.x * valueDto.y;
    }

}
