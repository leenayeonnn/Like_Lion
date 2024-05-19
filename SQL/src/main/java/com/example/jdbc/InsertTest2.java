package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest2 {
    public static void main(String[] args) {
        // 1. 필요 객체 선언
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 2. 접속
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost/exampleDB";
            String user = "skdus";
            String password = "skdus1234";
            conn = DriverManager.getConnection(dbUrl, user, password);
            conn.setAutoCommit(false);

            ////////////////
            String sql = "INSERT INTO dept(deptno, dname, loc) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql);

            int deptno = 60;
            String dname = "test";
            String loc = "test";

            ps.setInt(1, deptno);
            ps.setString(2, dname);
            ps.setString(3, loc);

            System.out.println(ps.executeUpdate() + " insert!!");

            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 닫기
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
