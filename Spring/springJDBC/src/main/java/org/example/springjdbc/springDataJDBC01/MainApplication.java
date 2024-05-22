package org.example.springjdbc.springDataJDBC01;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(UserRepository userRepository) {
//        return args -> {
//            userRepository.save(new User("jun", "jun@gmail.com"));
//            userRepository.save(new User("park", "park@gmail.com"));
//            userRepository.save(new User("lee", "lee@gmail.com"));
//            userRepository.save(new User("kim", "kim@gmail.com"));
//
//            User user = userRepository.findById(8L).get();
//            System.out.println(user.getName());
//
//            PageRequest pageRequest = PageRequest.of(0, 2);
//            Page<User> allUser = userRepository.findAllUsersWithPagination(pageRequest);
//
//            allUser.forEach(u -> System.out.println(u.getName() + " - " + u.getEmail()));
//        };
//    }

    @Bean
    public CommandLineRunner batchUpdateDemo(JdbcTemplate jdbcTemplate) {
        return args -> {
            List<User> users = Arrays.asList(
                    new User(null, "Alice", "alice@example.com"),
                    new User(null, "Bob", "bob@example.com"),
                    new User(null, "Charlie", "charlie@example.com"),
                    new User(null, "David", "david@example.com")
            );

            String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

            int[] updateCounts = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    User user = users.get(i);
                    ps.setString(1, user.getName());
                    ps.setString(2, user.getEmail());
                }

                @Override
                public int getBatchSize() {
                    return users.size();
                }
            });
            System.out.println("batch update complete. num : " + Arrays.toString(updateCounts));
        };
    }
}
