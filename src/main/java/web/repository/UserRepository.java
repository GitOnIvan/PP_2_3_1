package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> getUsersList();
    public User getUserByID(long id);
    public void addNewUser(User user);
    public void updateUser(long id, User updatedUser);
    public void deleteUser(long id);
}
