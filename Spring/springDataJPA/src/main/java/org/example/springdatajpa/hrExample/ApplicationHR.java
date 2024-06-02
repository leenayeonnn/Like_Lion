package org.example.springdatajpa.hrExample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class ApplicationHR {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationHR.class, args);
    }
}
