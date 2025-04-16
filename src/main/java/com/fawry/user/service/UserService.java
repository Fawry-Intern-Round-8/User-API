package com.fawry.user.service;

import com.fawry.user.entity.Users;

import java.util.List;

public interface UserService {
    Users saveUser(Users user);

    Users getUser(int id);

    List<Users> getUsers();

    void activateUser(int id);

    void deactivateUser(int id);

    void deleteUser(int id);
}
