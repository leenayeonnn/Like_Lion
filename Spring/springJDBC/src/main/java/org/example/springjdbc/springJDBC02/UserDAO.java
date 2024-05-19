package org.example.springjdbc.springJDBC02;

import org.springframework.transaction.annotation.Transactional;

public interface UserDAO {
    @Transactional
    public void createAndUpdateUser(String name, String email, String newEmail);
}
