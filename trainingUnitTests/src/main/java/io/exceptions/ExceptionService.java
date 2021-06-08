package io.exceptions;

public class ExceptionService {

    public int complexBusiness(int x, int y) {
        if (x < 0 || y < 0) throw new RuntimeException("Negative parameter");
        return x + y;
    }

    // OBSERVE if => adds extra business flows => and tests
    // OBSERVE if (complex condition)=> adds many more business flows => and tests
    // OBSERVE throws => adds more business flows => and tests

}
