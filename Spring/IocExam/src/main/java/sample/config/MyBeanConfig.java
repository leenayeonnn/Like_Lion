package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import sample.bean.MyBean;


public class MyBeanConfig {
    // <bean id="myBean" class="sample.bean.MyBean"/>

    // singletone 타입은 미리 생성되어짐 - static
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    public MyBean myBean2() {
        return new MyBean();
    }

    // prototype은 호출마다 생성됨 - non static
    @Bean
    @Scope("prototype")
    public MyBean myBean3() {
        return new MyBean();
    }

    @Bean
    public MyBean myBean4() {
        return new MyBean("test", 0);
    }
}
