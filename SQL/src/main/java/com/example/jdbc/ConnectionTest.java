package com.example.jdbc;
// 1. lib 추가

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 0-1. 드라이버 로딩
        String dbUrl = "jdbc:mysql://localhost/exampleDB";
        String user = "skdus";
        String password = "skdus1234";

        // 1. 접속 객체 얻어오기
        Connection conn = DriverManager.getConnection(dbUrl, user, password);

        if (conn != null) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }

        String dname = "개발부";
        String sql = "INSERT INTO dept(deptno, dname) VALUES (3,'" + dname + "')";
        // DBMS는 쿼리가 들어오면 번역
        // 같은 쿼리가 들어오면 이미 번역된 것 이용
        // 값이 바뀌면 다른 쿼리로 인식해서 매번 번역하게 됨

        String sql2 = "INSERT INTO dept(deptno, dname) VALUES (3, ?)";
        // prepared statement 사용하면
        // 정의 해놓고 나중에 값이 바뀌기 때문에
        // 매번 번역하지 않음 => 간결 / 성능 면에서 더 좋음
    }
}
