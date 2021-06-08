package io.special;

public class SpecialCaseService {

    public int complexBusiness(int x, int y) {
        if (x < 0 || y < 0) return 0;
        return x + y;
    }

    // OBSERVE if => adds extra business flows => and tests
    // OBSERVE if (complex condition)=> adds many more business flows => and tests

}
