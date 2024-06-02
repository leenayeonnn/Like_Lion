package org.example.springdatajpa.example2;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class application2 {
    public static void main(String[] args) {
        SpringApplication.run(application2.class, args);
    }

    @Bean
    public CommandLineRunner run(CustomerRepository cr) {
        return args -> {
//            List<Customer> customer = cr.findAll();
//            for (Customer c : customer) {
//                System.out.println(c.getName());
//            }
        };
    }
}
