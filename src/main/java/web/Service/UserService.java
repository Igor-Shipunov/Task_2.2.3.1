package web.Service;

import web.model.User;

import java.util.List;

public interface UserService {

    void create(User user);

    List<User> readAll(User user);

    void update(User user);

    void delete(User user);
}
