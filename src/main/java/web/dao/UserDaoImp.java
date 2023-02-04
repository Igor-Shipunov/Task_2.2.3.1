package web.dao;

import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public List<User> readAll(User user) {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void update(User user) {
        entityManager.find(User.class, user);
        //сеттеры
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
        entityManager.flush();
    }
}
