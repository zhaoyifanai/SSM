package spring.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MyConfig.class})
public class MyBeanConfig {

    @Bean
    public void sayHello(){
        System.out.println("Hello MyBeanConfig!");
    }
}
