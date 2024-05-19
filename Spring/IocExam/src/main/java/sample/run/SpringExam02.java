package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.bean.MyBean;
import sample.config.MyBeanConfig2;

public class SpringExam02 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig2.class);

        MyBean bean1 = (MyBean) context.getBean("myBean"); //lookup 방식
        bean1.setName("lee");
        System.out.println(bean1);

        MyBean bean2 = (MyBean) context.getBean("myBean");
        bean2.setName("kim");
        System.out.println(bean2);
        System.out.println(bean1); // singletone으로 설정했기 때문에 1과 2는 같은 인스턴스임

//        MyBean bean3 = context.getBean(MyBean.class); // 같은 타입의 생성자가 2개이기 때문에 타입으로 호출 시 모호성에 의해 에러 발생
        MyBean bean3 = context.getBean("myBean2", MyBean.class); // id를 제공하여 모호성 없애주기
        bean3.setName("park");
        System.out.println(bean3);
        System.out.println(bean1); // myBean, myBean2로 각각 생성하기에 서로 다른 인스턴스임

        MyBean bean4 = context.getBean("myBean3", MyBean.class);
        MyBean bean5 = context.getBean("myBean3", MyBean.class);

        bean4.setName("kang");
        bean5.setName("song");

        System.out.println(bean4);
        System.out.println(bean5);

        MyBean bean6 = context.getBean("myBean4", MyBean.class);
        System.out.println(bean6);

        // 3. xml 통해서

    }
}
