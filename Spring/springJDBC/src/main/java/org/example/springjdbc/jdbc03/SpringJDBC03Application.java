package org.example.springjdbc.jdbc03;

import java.util.List;
import org.example.springjdbc.jdbc03.dao.User;
import org.example.springjdbc.jdbc03.dao.UserDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJDBC03Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBC03Application.class, args);
    }

    @Bean
    public CommandLineRunner demo3(UserDAO userDAO) {
        return args -> {
            userDAO.insertUser(new User(6, "park", "park@gmail.com"));

            List<User> users = userDAO.findAllUsers();
            users.forEach(System.out::println);

            userDAO.updateUserEmail("park", "test");

            userDAO.deleteUser("park");
        };
    }
}
