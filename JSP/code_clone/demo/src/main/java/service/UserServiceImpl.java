package service;

import java.util.*;

import org.springframework.stereotype.Service;

import model.*;

@Service
public class UserServiceImpl implements UserService {
    private final Map<Long, User> users = new HashMap<>();
    private long nextId = 1L;

    // create
    public User createUser(User user) {
        user.setId(nextId);
        users.put(user.getId(), user);
        return user;
    }

    // read
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(long id) {
        return users.get(id);
    }

    // update
    public User updateUser(long id, User updateUser) {
        User user = users.get(id);

        if (user != null) {
            user.setName(updateUser.getName());
            user.setEmail(updateUser.getEmail());
        }
        return user;
    }

    // delete
    public boolean deleteUser(long id) {
        return users.remove(id) != null;
    }
}
