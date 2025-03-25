package com.fawry.User_API.dao;

import com.fawry.User_API.entity.Users;

import java.util.List;

public interface UserDAO {
    Users saveUser(Users user);

    Users getUser(int id);

    List<Users> getUsers();

    void activateUser(int id);

    void deactivateUser(int id);

    void deleteUser(int id);
}
