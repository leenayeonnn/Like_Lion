package org.example.iocexam.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
public class DefaultConfig {
    @Bean
    public DataService dataservice() {
        return new DataService("default env");
    }
}
