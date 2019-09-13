package unitils.service;

import unitils.model.User;

import java.util.ArrayList;
import java.util.List;

public class Service {

    public User getCurrentBusinessUser() {
        return new User(1, "John", "Doe");
    }

    public List<User> getCurrentBusinessUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "John1", "Doe1"));
        users.add(new User(2, "John2", "Doe2"));
        users.add(new User(3, "John3", "Doe3"));
        return users;
    }

}
