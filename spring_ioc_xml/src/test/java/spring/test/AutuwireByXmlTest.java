package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.controller.UserController;

public class AutuwireByXmlTest {

    /**
     * 自动装配：
     * 根据指定的策略，在IOC容器中匹配某一个bean，自动为指定的bean中所依赖的类类型或接口类型属性赋值
     * byType：根据类型匹配IOC容器中的某个兼容类型的bean，为属性自动赋值
     * > 若在IOC中，没有任何一个兼容类型的bean能够为属性赋值，则该属性不装配，即值为默认值null
     * > 若在IOC中，有多个兼容类型的bean能够为属性赋值，则抛出异常NoUniqueBeanDefinitionException
     * byName：将自动装配的属性的属性名，作为bean的id在IOC容器中匹配相对应的bean进行赋值
     */
    @Test
    public void testAutowire(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }

}
