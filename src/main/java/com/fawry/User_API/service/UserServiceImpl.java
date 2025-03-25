package com.fawry.User_API.service;

import com.fawry.User_API.dao.UserDAO;
import com.fawry.User_API.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public Users saveUser(Users user) {
        return userDAO.saveUser(user);
    }

    @Override
    public Users getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    public List<Users> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    @Transactional
    public void activateUser(int id) {
        userDAO.activateUser(id);
    }

    @Override
    @Transactional
    public void deactivateUser(int id) {
        userDAO.deactivateUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
