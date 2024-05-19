package org.example.springjdbc.SpringJDBC03;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringJDBC03Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBC03Application.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(UserService userService) {
//        return args -> {
//            try {
//                userService.executeComplexBusinessProcess("pon", "pon@email.com");
//            } catch (RuntimeException e) {
//                System.out.println(e.getMessage());
//            }
//        };
//    }

//    @Bean
//    public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
//        return args -> {
//            String sql = "SELECT id, name, email FROM users";
//            List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
//            users.forEach(user -> System.out.println(user));
//        };
//    }

    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
        return args -> {
            String sql = "SELECT id, name, email FROM users";
            User user = jdbcTemplate.query(sql, new UserResultSetExtractor());
            System.out.println(user);
        };
    }
}
