package org.example.springjdbc.jdbc02.dao;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAOImple implements UserDAO {
    //    @Autowired // 필드기반
    private final JdbcTemplate jdbcTemplate;

//    // 생성자 기반
//    public UserDAOImple(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    // setter 기반
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO users(name, email) VALUES (?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail());
    }

    @Override
    public List<User> findAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public void updateUserEmail(String name, String email) {
        String sql = "UPDATE users SET email = ? WHERE name = ?";
        jdbcTemplate.update(sql, email, name);
    }

    @Override
    public void deleteUser(String name) {
        String sql = "DELETE FROM users WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }
}
