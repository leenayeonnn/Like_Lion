package org.example.springjdbc.jdbc02.dao;

import java.util.List;

public interface UserDAO {
    void insertUser(User user);
    List<User> findAllUsers();
    void updateUserEmail(String name, String email);
    void deleteUser(String name);
}
