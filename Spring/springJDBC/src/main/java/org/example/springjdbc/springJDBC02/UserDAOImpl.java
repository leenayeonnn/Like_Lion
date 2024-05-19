package org.example.springjdbc.springJDBC02;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void createAndUpdateUser(String name, String email, String newEmail) {
        jdbcTemplate.update("INSERT INTO users (name, email) VALUES (?, ?)", name, email);

        if (newEmail.contains("error")) {
            throw new RuntimeException("Simulated error");
        }
        jdbcTemplate.update("UPDATE users SET email = ? WHERE name = ?", newEmail, name);
    }
}