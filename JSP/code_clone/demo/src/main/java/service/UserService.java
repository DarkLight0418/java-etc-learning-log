package service;

import java.util.List;

import model.User;

public interface UserService {
    public User createUser(User user);
    public List<User> getAllUsers();
    public User getUserById(long id);
    public User updateUser(long id, User updateUser);
    public boolean deleteUser(long id);
}
