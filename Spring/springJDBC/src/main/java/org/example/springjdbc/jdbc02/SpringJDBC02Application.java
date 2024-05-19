package org.example.springjdbc.jdbc02;

import java.util.List;
import org.example.springjdbc.jdbc02.dao.User;
import org.example.springjdbc.jdbc02.dao.UserDAO;
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
    public CommandLineRunner demo2(UserDAO userDAO) {
        return args -> {
            userDAO.insertUser(new User(6, "park", "park@gmail.com"));

            List<User> users = userDAO.findAllUsers();
            users.forEach(System.out::println);

            userDAO.updateUserEmail("park", "test");

            userDAO.deleteUser("park");
        };
    }
}
