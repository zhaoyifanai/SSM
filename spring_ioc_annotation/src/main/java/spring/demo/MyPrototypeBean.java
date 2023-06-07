package spring.demo;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyPrototypeBean {
    public void sayHello(){
        System.out.println("Hello MyPrototypeBean!");
    }
}
