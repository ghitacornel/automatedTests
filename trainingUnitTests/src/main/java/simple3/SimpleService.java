package simple3;

import java.util.stream.IntStream;

class SimpleService {

    // multiple execution paths
    // some execution paths end with exception raised
    // kind reminder => a "throw" is equivalent with a "return" but is used for "exception"al cases
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
