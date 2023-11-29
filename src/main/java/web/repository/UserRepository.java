package web.repository;


import web.model.User;
import java.util.List;

public interface UserRepository{
    public List<User> getUsersList();
    public User getUserByID(long id);
    public void addNewUser(User user);
    public void updateUser(long id, User updatedUser);
    public void deleteUser(long id);
}
