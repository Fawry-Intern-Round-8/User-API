package com.fawry.user.rest;

import com.fawry.user.entity.Users;
import com.fawry.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserRestController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping
    public List<Users> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public Users getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @PostMapping()
    public Users addUser(@RequestBody Users user) {
        user.setId(0);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return user;
    }

    @PutMapping()
    public Users updateUser(@RequestBody Users user) {
        return userService.saveUser(user);
    }


    
    @PutMapping("/{userId}")
    public Users updateUserById(@PathVariable int userId, @RequestBody Users user) {
        user.setId(userId);
        return userService.saveUser(user);
    }

    @PutMapping("/{userId}/activate")

    public void activateUser(@PathVariable int userId) {
        userService.activateUser(userId);
    }

    @PutMapping("/{userId}/deactivate")
    public void deactivateUser(@PathVariable int userId) {
        userService.deactivateUser(userId);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return "Deleted user id - " + userId;
    }
}
