package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.pojo.Student;

public class IOCByXMLTest {

    /**
     * 获取bean三种方式：
     * ①方式一：根据id获取
     * ②方式二：根据类型获取
     * 注意：当根据类型获取bean时，要求IOC容器中指定类型的bean有且只能有一个
     * 当IOC容器中一共配置了两个，会抛出异常
     * ③方式三：根据id和类型
     */
    @Test
    /**
     * 测试获取bean
     */
    public void testIOC() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        //1.根据id获取bean
        //Student studentOne = (Student) ioc.getBean("studentOne");
        //2.根据类型获取bean
        //Student student = ioc.getBean(Student.class);
        //3.根据类型和id获取
        Student student = ioc.getBean("studentOne", Student.class);
        System.out.println(student);
    }

    @Test
    /**
     * 测试依赖注入之setter注入
     */
    public void testDI() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        // 获取bean
        Student studentEnum = (Student) ioc.getBean("studentEnum");
        System.out.println(studentEnum);
        //Student student = ioc.getBean("studentTwo", Student.class);
        /*Student student = ioc.getBean("studentOne", Student.class);
        System.out.println(student);*/
        /*Clazz clazz = ioc.getBean("clazzOne", Clazz.class);
        System.out.println(clazz);*/


    }

    @Test
    /**
     * 测试依赖注入之构造器注入
     */
    public void testDI2() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //根据类型和id获取bean
        Student student = ioc.getBean("studentThree", Student.class);
        System.out.println(student);
    }

    @Test
    /**
     * 枚举管理的Bean
     */
    public void testGetBeans(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        // 返回工厂的BeanDefinition总数
        int count = ioc.getBeanDefinitionCount();
        System.out.println(count);
        // 返回工厂中所有Bean的名字
        String[] names = ioc.getBeanDefinitionNames();
        for (int i = 0; i < names.length ; i++) {
            System.out.println(names[i]);
        }


    }
}
