package service;

public class ValidationService {

    public void validate(int a, int b) {
        if (a < 0 || b < 0) throw new RuntimeException("negative values detected");
        if (a == 0 || b == 0) throw new RuntimeException("zero values detected");
    }

}
