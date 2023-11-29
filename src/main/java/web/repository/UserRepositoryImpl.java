package web.repository;


import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private static long USER_COUNT;
    private List<User> users;


    {
        users = new ArrayList<>();
        users.add(new User(++USER_COUNT, "Brian", "May", "male", 76));
        users.add(new User(++USER_COUNT, "Ava", "Max", "female", 29));
        users.add(new User(++USER_COUNT, "Daniel", "Reynolds", "male", 36));
        users.add(new User(++USER_COUNT, "Edward", "Sheeran", "male", 32));
        users.add(new User(++USER_COUNT, "Brian", "Johnson", "male", 76));
        users.add(new User(++USER_COUNT, "Billie", "Eilish", "female", 21));




    }


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
        User userToBeDeleted = getUserByID(id);
        users.remove(users.indexOf(userToBeDeleted));

    }
}
