package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import sample.bean.MyBean;

@ComponentScan(basePackages = "sample")
public class MyBeanConfig2 {
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
