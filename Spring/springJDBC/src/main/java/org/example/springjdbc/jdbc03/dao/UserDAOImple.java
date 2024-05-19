package org.example.springjdbc.jdbc03.dao;

import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.springjdbc.jdbc03.UserNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAOImple implements UserDAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO users(name, email) VALUES (?, ?)";
        try {
            jdbcTemplate.update(sql, user.getName(), user.getEmail());
        } catch (DataAccessException e) {
            throw new DataAccessException("error inserting user" + user.getName(), e) {
            };
        }
    }

    @Override
    public List<User> findAllUsers() {
        String sql = "SELECT * FROM users";
        try {
            List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
            return users;
        } catch (DataAccessException e) {
            throw new DataAccessException("error finding all users") {
            };
        }
    }

    @Override
    public void updateUserEmail(String name, String email) {
        String sql = "UPDATE users SET email = ? WHERE name = ?";
        int update = jdbcTemplate.update(sql, email, name);
        if (update == 0) {
            throw new UserNotFoundException("can not find user (name = " + name + ")");
        }
    }

    @Override
    public void deleteUser(String name) {
        String sql = "DELETE FROM users WHERE name = ?";
        int update = jdbcTemplate.update(sql, name);
        if (update == 0) {
            throw new UserNotFoundException("can not find user (name = " + name + ")");
        }
    }
}
