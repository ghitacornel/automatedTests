package simple;

import java.util.stream.IntStream;

public class SimpleService {

    // simple, linear
    public int simpleBusinessMethod(int a, int b) {
        return a + b;
    }

    // simple but with multiple execution paths
    // need to identify each execution path and test them individually
    public int businessMethodWithMultipleExecutionPaths(int x) {
        return x < 0 ? -x : x;
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
}
