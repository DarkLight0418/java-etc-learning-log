package controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // create
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // read all
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // read one
    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    // update
    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        boolean removed = userService.deleteUser(id);
        return removed ? "삭제 성공" : "유저 못찾음";
    }
}   
