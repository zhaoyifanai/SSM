package spring.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.dao.UserDao;
import spring.dao.impl.UserDaoImpl;
import spring.service.UserService;
import spring.service.impl.UserServiceImpl;

@Configuration
public class MyConfig {

    @Bean
    public void message() {
        System.out.println("Hello, World!");
    }



}
