package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void createNewUser(User user);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(User user);

    User getUserById(int id);
}
