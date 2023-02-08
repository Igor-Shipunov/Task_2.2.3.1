package web.dao;

import web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createNewUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
        entityManager.flush();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
}
