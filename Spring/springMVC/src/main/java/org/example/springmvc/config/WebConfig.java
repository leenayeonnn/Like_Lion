package org.example.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class WebConfig {
    @Bean
    public MyCustomViewResolver myCustomViewResolver(){
        MyCustomViewResolver resolver = new MyCustomViewResolver();
        resolver.setOrder(0);
        return resolver;
    }
}
