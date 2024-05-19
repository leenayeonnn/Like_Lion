package org.example.springjdbc.SpringJDBC04;

import java.util.Map;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private Properties sqlQueries;

    public void insertUser(User user) {
        String sql = sqlQueries.getProperty("INSERT_USER");
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name", user.getName());
        mapSqlParameterSource.addValue("email", user.getEmail());
        jdbcTemplate.update(sql, mapSqlParameterSource);
    }
}
