package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.demo.*;

public class TestDemo {

    @Test
    public void test3(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        MyConfig myConfig = ioc.getBean(MyConfig.class);
        myConfig.message();
    }

    @Test
    public void test4() throws Exception {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        MyBeanIAD myBeanIAD = ioc.getBean(MyBeanIAD.class);
        myBeanIAD.afterPropertiesSet();
        myBeanIAD.destroy();
    }

    @Test
    public void test5() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        MyBeanIB myBeanIB = ioc.getBean(MyBeanIB.class);
        myBeanIB.getBeanName();
    }

    @Test
    public void test6(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        MyPrototypeBean myPrototypeBean = ioc.getBean(MyPrototypeBean.class);
        myPrototypeBean.sayHello();
    }

    @Test
    public void test7(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        MyBeanConfig myBeanConfig = ioc.getBean(MyBeanConfig.class);
        myBeanConfig.sayHello();
    }
}
