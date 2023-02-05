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
    private EntityManager entityManager;

    @Override
    public void create(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public List<User> readAll() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void update(User user) {
        //entityManager.find(User.class, user);
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void delete(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user)); //mb by entity.find
        entityManager.flush();
    }

    @Override
    public User readById(int id) {
        return entityManager.find(User.class, id);
    }
}
