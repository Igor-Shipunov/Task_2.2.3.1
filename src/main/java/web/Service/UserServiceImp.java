package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

//@Component
@Service //хз на счет анотации
@Transactional
public class UserServiceImp implements UserService {

    //private UserDaoImp userDao = new UserDaoImp();

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public List<User> readAll() {return userDao.readAll();}

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User readById(int id) {
        return userDao.readById(id);
    }
}
