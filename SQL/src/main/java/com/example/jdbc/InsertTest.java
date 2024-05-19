package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
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

            // 3. 쿼리 작성
            String sql = "INSERT INTO dept(deptno, dname, loc) VALUES (50, '개발부', '서울')";
            ps = conn.prepareStatement(sql);

            // 4. 실행
            int count = ps.executeUpdate();
            System.out.println(count + " insert!!");

            ////////////////
            sql = "UPDATE dept SET deptno = 60 WHERE deptno = 50";
            ps = conn.prepareStatement(sql);
            System.out.println(ps.executeUpdate() + " update!!");

            sql = "DELETE FROM dept WHERE deptno = 60";
            ps = conn.prepareStatement(sql);
            System.out.println(ps.executeUpdate() + " delete!!");

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
