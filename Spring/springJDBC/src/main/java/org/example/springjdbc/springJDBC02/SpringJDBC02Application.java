package org.example.springjdbc.springJDBC02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJDBC02Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBC02Application.class, args);
    }

    @Bean
    public CommandLineRunner transactionDemo(UserDAO userDAO) {
        return args -> {
            try {
                userDAO.createAndUpdateUser("test2", "test2@gmail.com", "test2@error.com");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
    }
}
