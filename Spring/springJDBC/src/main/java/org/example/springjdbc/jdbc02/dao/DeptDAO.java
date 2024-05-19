package org.example.springjdbc.jdbc02.dao;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeptDAO {
    private JdbcTemplate jdbcTemplate;
    public List<Dept> getDepts() {
        return jdbcTemplate.query("SELECT deptno, dname, loc FROM DEPT", new DeptRowMapper());
    }
}
