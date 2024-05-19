package org.example.springjdbc.SpringJDBC05;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJDBC05Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBC05Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserDAO userDAO) {
        return args -> {
            User user = new User();
            user.setName("haha");
            user.setEmail("haha@email.com");

            User result = userDAO.insertUser(user);

            System.out.println(user.getId());
        };
    }
}
