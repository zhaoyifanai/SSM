package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aop.annotation.Calculator;
import spring.aop.annotation.CalculatorImpl;

public class AopTest {

    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");

        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(10,1);

    }
}
