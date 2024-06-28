package service.impl;

import bean.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    private static final User[] USERS = {
            new User("user1", "pass1"),
            new User("user2", "pass2")
    };
    public boolean authenticate(String username, String password) {
        for (User user : USERS) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
