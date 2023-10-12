package simple4;

class SimpleService {

    // note that is not a good design to have methods that alter the input data
    // think about pure functions ( https://en.wikipedia.org/wiki/Pure_function )
    // but sometimes this kind of method are very useful (e.g. merging data methods)
    public void businessMethodThatAltersInputData(InputData inputData) {
        inputData.setX(inputData.getX() + 1);
    }
}
