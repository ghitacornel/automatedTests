package service;

public class BusinessService {

    public String businessMethod(String input) {
        return input + privateMethod(input);
    }

    private String privateMethod(String input) {
        return input + input + input;
    }
}
