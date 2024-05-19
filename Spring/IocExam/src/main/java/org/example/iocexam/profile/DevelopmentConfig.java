package org.example.iocexam.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevelopmentConfig {
    @Bean
    public DataService dataService(){
        return new DataService("dev env");
    }
}
