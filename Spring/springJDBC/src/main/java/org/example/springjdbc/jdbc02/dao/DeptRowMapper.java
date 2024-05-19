package org.example.springjdbc.jdbc02.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class DeptRowMapper implements RowMapper<Dept> {
    @Override
    public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dept dept = new Dept();
        dept.setId(rs.getInt("deptno"));
        dept.setName(rs.getString("dname"));
        dept.setLoc(rs.getString("loc"));
        return dept;
    }
}
