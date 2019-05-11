package pl.borowik.service;

import pl.borowik.model.User;

import java.util.Map;

public interface UserService {

    void saveUser(User user);

    boolean isUserAlreadyPresent(User user);

    User findById(int theId);

    User findByEmail(String email);
}
