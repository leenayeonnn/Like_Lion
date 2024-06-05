package org.example.springdatajpa.example1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository userRepository) {
        return args -> {
//            User user = new User("test", "test@email.com");
//            userRepository.save(user);
//            log.info("User saved : {}", user.getName());
//            log.info("User saved : {}", user.getId());

//            userRepository.save(new User("lee", "lee@email.com"));
//
//            userRepository.delete(user);
//            log.info("User deleted : {}", user.getName());
//            log.info("User deleted : {}", user.getId());


//            List<User> users = userRepository.findByName("test");
//            users.forEach(user -> log.info("user id : {}", user.getId()));
        };
    }
}
