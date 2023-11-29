package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

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
        return users;
    }

    @Override
    public User getUserByID(long id) {

        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void addNewUser(User user) {
        user.setId(++USER_COUNT);
        users.add(user);

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
