package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    // DB 접속
    public static Connection getConnection() {
        String dbUrl = "jdbc:mysql://localhost/exampleDB";
        String user = "skdus";
        String password = "skdus1234";
        return getConnection(dbUrl, user, password);
    }

    public static Connection getConnection(String dbUrl, String user, String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(Connection conn, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        close(conn);
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        close(conn, ps);
    }
}
