package org.example.iocexam.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MainApplication.class, args);
        DataService dataService = context.getBean(DataService.class);
        System.out.println(dataService.getEnv());
    }
}
