package spring.aop.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ValidateAspect {

    @Pointcut("execution(* spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut2(){}

    //@Before("execution(* spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("spring.aop.annotation.LoggerAspect.pointCut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect-->前置通知");
    }

    @After("pointCut2()")
    public void afterMethod(){
        System.out.println("ValidateAspect-->后置通知");
    }

}
