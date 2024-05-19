package org.example.springjdbc.SpringJDBC04;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringJDBC04Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBC04Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserDAO userDAO) {
        return args -> {
            User user = new User(null, "who", "who@email.com");
            userDAO.insertUser(user);
        };
    }
}
