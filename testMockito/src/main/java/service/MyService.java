package service;

import model.Model;

public class MyService {

    private ValidationService validationService = new ValidationService();

    public String changeModel(Model model) {
        model.setId(model.getId() + 1);
        return model.getName();
    }

    public int sum(int a, int b) {
        validationService.validate(a, b);
        return a + b;
    }
}
