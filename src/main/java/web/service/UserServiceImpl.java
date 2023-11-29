package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public List<User> getUsersList() {
        return userDAO.getUsersList();
    }

    @Override
    public User getUserByID(long id) {
        return userDAO.getUserByID(id);
    }

    @Override
    public void addNewUser(User user) {
        userDAO.addNewUser(user);
    }

    @Override
    public void updateUser(long id, User updatedUser) {
        userDAO.updateUser(id, updatedUser);

    }

    @Override
    public void deleteUser(long id) {
        userDAO.deleteUser(id);

    }
}
