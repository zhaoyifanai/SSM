package spring.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MyBeanIAD implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("MyBean is destroyed.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyBean is initialized.");
    }
}
