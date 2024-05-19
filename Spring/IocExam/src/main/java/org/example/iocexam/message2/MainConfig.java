package org.example.iocexam.message2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ServiceConfig.class)
public class MainConfig {
    MainConfig() {
        System.out.println("MainConfig create");
    }
}
