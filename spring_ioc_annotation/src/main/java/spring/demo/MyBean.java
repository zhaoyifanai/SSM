package spring.demo;

import org.springframework.stereotype.Component;

@Component
public class MyBean {


    public void sayHello(){
        System.out.println("MyBean - sayHello()");
    }
}
