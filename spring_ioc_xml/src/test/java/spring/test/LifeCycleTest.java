package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.pojo.User;

public class LifeCycleTest {

    /**
     * 1：实例化
     * 2：依赖注入
     * 3：后置处理器postProcessBeforeInitialization
     * 4：初始化  使用init-method属性指定初始化方法
     * 5：后置处理器postProcessAfterInitialization
     * 6：销毁  使用destroy-method属性指定销毁方法
     *
     * 注意：
     * 若bean的作用域为单例时，生命周期的前三个步骤会在获取IOC容器时执行
     * 若bean的作用域为多例时，生命周期的前三个步骤会在获取bean时执行
     */
    @Test
    public void test(){
        //ConfigurableApplicationContext是ApplicationContext子接口，其中扩展了刷新和关闭容器的方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }
}
