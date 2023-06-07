package spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MyInject {

    @Autowired
    MyBean myBeanByAutowired;

    @Resource
    MyBean myBeanByResource;

    public void sayHello(){
        System.out.println("MyInject - sayHello()");
        System.out.println("MyInject - call myBeanByAutowired.sayHello");
        myBeanByAutowired.sayHello();
        System.out.println("MyInject - call myBeanByResource.sayHello");
        myBeanByResource.sayHello();

    }
}
