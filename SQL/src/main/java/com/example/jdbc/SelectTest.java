package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String dbUrl = "jdbc:mysql://localhost/exampleDB";
        String user = "skdus";
        String password = "skdus1234";
        try {
            conn = DriverManager.getConnection(dbUrl, user, password);

            ps = conn.prepareStatement("SELECT deptno, dname, loc FROM dept");

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.print(rs.getInt("deptno") + " ");
                System.out.print(rs.getString("dname") + " ");
                System.out.println(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

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
