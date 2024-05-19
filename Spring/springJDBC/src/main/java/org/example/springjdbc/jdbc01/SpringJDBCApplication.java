package org.example.springjdbc.jdbc01;

import java.sql.ResultSet;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@SpringBootApplication
public class SpringJDBCApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBCApplication.class);
    }

    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
        return args -> {
            // user 입력
//            String sql = "INSERT INTO users(name, email) VALUES(?,?)";
//            jdbcTemplate.update(sql, "kim", "kim@gmail.com");


            // update
            String modify = "UPDATE users SET email = ? WHERE name = ?";
            jdbcTemplate.update(modify, "test@gmail.com", "kim");

            // delete
            String delete = "DELETE FROM users WHERE id = ?";
            jdbcTemplate.update(delete, "4");

            // Read
            // rowMapper 를 이용해야하는 이유
            // 결과값 담을 때 테이블의 커럼과 User class의 필드를 매칭
            // 테이블의 컬럼과 클래스의 필드가 완전 일치 시 자동적으로 매칭됨
            RowMapper<User> rowMapper = (ResultSet rs, int rowNum) -> new User(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("email")
            );

//            List<User> users = jdbcTemplate.query("SELECT id, name, email FROM users",
//                    new BeanPropertyRowMapper<>(User.class));
            List<User> users = jdbcTemplate.query("SELECT id, name, email FROM users", rowMapper);

            users.forEach(System.out::println);
        };
    }
}
