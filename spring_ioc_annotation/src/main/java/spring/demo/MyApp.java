package spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.controller.UserController;

public class MyApp {

    public static void main(String[] args){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        MyBean myBean = ioc.getBean(MyBean.class);
        myBean.sayHello();

        MyInject myInject = ioc.getBean(MyInject.class);
        myInject.sayHello();
    }
}
