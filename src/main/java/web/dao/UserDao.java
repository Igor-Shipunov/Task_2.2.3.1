package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void create(User user);

    List<User> readAll();

    void update(User user);

    void delete(User user);

    User readById(int id);
}
