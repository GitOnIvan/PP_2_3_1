package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.repository.UserRepository;
import web.model.User;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public List<User> getUsersList() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User getUserByID(long id) {
        return userRepository.findOne(id)
    }

    @Override
    @Transactional
    public void addNewUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public void updateUser(long id, User updatedUser) {
        userDAO.updateUser(id, updatedUser);

    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteById(id);

    }
}
