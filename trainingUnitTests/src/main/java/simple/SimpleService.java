package simple;

import java.util.stream.IntStream;

public class SimpleService {

    // simple method, linear execution path
    public int simpleBusinessMethod(int a, int b) {
        return a + b;
    }

    // method with multiple execution paths
    // need to identify each execution path and test them individually
    public int businessMethodWithMultipleExecutionPaths(int x) {
        if (x < 0) {
            return -x;
        } else {
            return x;
        }
    }

    // multiple execution paths
    // some execution paths end with exception raised
    // need to identify each execution path and test them individually
    // need to verify the raised exception type and message
    public int businessMethodWithExceptions(int x) {
        if (x < 0) {
            throw new RuntimeException("negative value");
        }
        if (x == 0) {
            return 1;
        }
        return IntStream.range(1, x + 1).reduce(1, (a, b) -> a * b);
    }

    // note that is not a good design to have methods that alter the input data
    // think about pure functions ( https://en.wikipedia.org/wiki/Pure_function )
    // but sometimes this kind of methods are very useful (e.g. merging data methods)
    public void businessMethodThatAltersInputData(InputData inputData) {
        inputData.setX(inputData.getX() + 1);
    }
}
