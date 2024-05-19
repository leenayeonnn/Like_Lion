package org.example.springjdbc.SpringJDBC03;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        return new User(id, name, email);
    }
}
