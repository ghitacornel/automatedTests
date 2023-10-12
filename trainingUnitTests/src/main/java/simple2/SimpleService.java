package simple2;

class SimpleService {

    // method with multiple execution paths
    // need to identify each execution path and test it individually
    public int businessMethodWithMultipleExecutionPaths(int x) {
        if (x < 0) {
            return -x;
        } else {
            return x;
        }
    }

}
