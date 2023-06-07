package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.controller.UserController;
import spring.dao.UserDao;
import spring.service.UserService;

public class IOCByAnnotationTest {


    /**
     * @Component：将类标识为普通组件
     * @Controller：将类标识为控制层组件
     * @Service：将类标识为业务层组件
     * @Repository：将类标识为持久层组件
     *
     * 组件所对应的bean的id
     * 默认情况
     * 类名首字母小写就是bean的id。例如：UserController类对应的bean的id就是userController。
     * 自定义bean的id
     * 可通过标识组件的注解的value属性设置自定义的bean的id
     *
     *  @Autowired注解
     * 1.@Autowired注解能够标识的位置
     * a>在成员变量上直接标记可完成自动装配，不需要提供setXxx()方法。
     * b>@Autowired注解可以标记在set方法上
     * c>@Autowired注解可以标记在构造器方法上
     *
     * 2.@Autowired注解原理
     * a>byType
     * b>byName
     * c>都不匹配
     * d>添加注解@Qualifier
     */
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
        /*System.out.println(userController);

        UserService userService = ioc.getBean("userServiceImpl",UserService.class);
        System.out.println(userService);

        UserDao userDao = ioc.getBean("userDaoImpl",UserDao.class);
        System.out.println(userDao);*/
        userController.saveUser();

    }
}
