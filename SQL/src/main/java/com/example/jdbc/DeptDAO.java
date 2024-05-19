package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDAO {
    // insert one tuple
    public static boolean addDept(DeptDTO deptDTO) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            conn = DBUtil.getConnection();

            String sql = "INSERT INTO dept(deptno, dname, loc) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setInt(1, deptDTO.getDeptno());
            ps.setString(2, deptDTO.getDname());
            ps.setString(3, deptDTO.getLoc());
            result = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps);
        }

        return result > 0;
    }

    // update
    public static boolean updateDept(DeptDTO deptDTO) {
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            conn = DBUtil.getConnection();

            String sql = "UPDATE dept SET dname = ?, loc = ? WHERE deptno = ?";
            ps = conn.prepareStatement(sql);

            ps.setString(1, deptDTO.getDname());
            ps.setString(2, deptDTO.getLoc());
            ps.setInt(3, deptDTO.getDeptno());
            result = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps);
        }

        return result > 0;
    }

    // delete
    public void deleteDept(int deptno) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement("DELETE FROM dept WHERE deptno = ?");
            ps.setInt(1, deptno);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, ps);
        }
    }

    // select all tuple
    public static List<DeptDTO> selectAllDept() {
        List<DeptDTO> deptDTOs = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "SELECT * FROM dept";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                deptDTOs.add(new DeptDTO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        return deptDTOs;
    }

    // select one tuple
    public static DeptDTO selectDeptById(int deptno) {
        DeptDTO deptDTO = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();

            String sql = "SELECT * FROM dept WHERE deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, deptno);
            rs = ps.executeQuery();

            if (rs.next()) {
                deptDTO = new DeptDTO(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        return deptDTO;
    }

    // select by condition
}