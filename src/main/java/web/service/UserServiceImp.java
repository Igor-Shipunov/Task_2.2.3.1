package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {


    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public void createNewUser(User user) {
        userDao.createNewUser(user);
    }

    @Override
    public List<User> getAllUsers() {return userDao.getAllUsers();}

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
