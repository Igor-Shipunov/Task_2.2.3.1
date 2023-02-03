package web.Service;

import web.dao.UserDaoImp;
import web.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Component
@Service //хз на счет анотации
public class UserServiceImp implements UserService {

    private UserDaoImp userDao = new UserDaoImp();

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public List<User> readAll(User user) {
        return null; //тут хз пока
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
}
