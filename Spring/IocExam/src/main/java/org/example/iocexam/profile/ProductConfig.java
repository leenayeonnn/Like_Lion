package org.example.iocexam.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProductConfig {
    @Bean
    public DataService dataservice(){
        return new DataService("prod env");
    }
}
