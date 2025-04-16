package com.fawry.user.rest;

import com.fawry.user.entity.Users;
import com.fawry.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{userId}")
    public Users getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/users")
    public Users addUser(@RequestBody Users user) {
        user.setId(0);
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users")
    public Users updateUser(@RequestBody Users user) {
        return userService.saveUser(user);
    }

    @PutMapping("/users/{userId}/activate")
    public void activateUser(@PathVariable int userId) {
        userService.activateUser(userId);
    }

    @PutMapping("/users/{userId}/deactivate")
    public void deactivateUser(@PathVariable int userId) {
        userService.deactivateUser(userId);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return "Deleted user id - " + userId;
    }
}
