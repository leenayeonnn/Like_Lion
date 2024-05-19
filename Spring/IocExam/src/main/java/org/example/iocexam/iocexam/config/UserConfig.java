package org.example.iocexam.iocexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.iocexam")
public class UserConfig {
    // IOC 컨테이너에 Bean 등록
    // 1. java config 이용해 동작되도록
    // 2. componentScan 이용해 동작되도록

    // 기본적으로 controller만 scan을 사용 할 수 있음
    // 단, 따로 이름을 주면 나머지도 scan을 활용할 수 있음

//    @Bean
//    public UserDAO userDAO() {
//        return new UserDAOImpl();
//    }
//
//    @Bean
//    public UserService userService(UserDAO userDAO){
//        return new UserServiceImple(userDAO);
//    }
}