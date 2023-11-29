package web.repository;


import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getUsersList() {

        return entityManager.createQuery("select u from User u ", User.class).getResultList();
    }

    @Override
    public User getUserByID(long id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id =:id", User.class);
        query.setParameter("id", id);

        return query.getResultList().stream().findAny().orElse(null);
    }


    @Override
    public void addNewUser(User user) {
        entityManager.persist(user);

    }






    @Override
    public void updateUser(long id, User updatedUser) {
        User userToBeUpdate = getUserByID(id);

        userToBeUpdate.setName(updatedUser.getName());
        userToBeUpdate.setAge(updatedUser.getAge());
        userToBeUpdate.setLastname(updatedUser.getLastname());
        userToBeUpdate.setSex(updatedUser.getSex());


    }

    @Override
    public void deleteUser(long id) {
        User entityToDelete = getUserByID(id);
        entityManager.remove(entityToDelete);


    }
}
