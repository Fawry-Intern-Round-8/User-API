package com.fawry.user.dao;

import com.fawry.user.entity.Users;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private final EntityManager entityManager;



    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Users saveUser(Users user) {
        return entityManager.merge(user);
    }

    public Users getUser(int id) {
        return entityManager.find(Users.class, id);
    }

    public List<Users> getUsers() {
        return entityManager.createQuery("from Users", Users.class).getResultList();
    }

    @Override
    public void activateUser(int id) {
        entityManager.find(Users.class, id).setStatus(true);
    }

    @Override
    public void deactivateUser(int id) {
        entityManager.find(Users.class, id).setStatus(false);
    }

    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(Users.class, id));
    }

    @Override
    public Users findByUsername(String username) {
        try {
            return entityManager.createQuery(
                            "SELECT u FROM Users u WHERE u.username = :username", Users.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("User does not exist");
        }
    }
}
