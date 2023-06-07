package spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
* 1、在切面中，需要将指定的注解将方法标识为通知方法
* 前置通知：使用@Before注解标识，在被代理的目标方法**前**执行
* 返回通知：使用@AfterReturning注解标识，在被代理的目标方法**成功结束**后执行（**寿终正寝**）
* 异常通知：使用@AfterThrowing注解标识，在被代理的目标方法**异常结束**后执行（**死于非命**）
* 后置通知：使用@After注解标识，在被代理的目标方法**最终结束**后执行（**盖棺定论**）
* 环绕通知：使用@Around注解标识，使用try...catch...finally结构围绕**整个**被代理的目标方法，包括上面四种通知对应的所有位置
*
*
* 2、切入点表达式：设置在标识通知的注解的value属性中
* execution(public int spring.aop.annotation.CalculatorImpl.add(int,int))
* execution(* spring.aop.annotation.CalculatorImpl.*(..))
* 第一个*表示任意的访问修饰符和返回值类型
* 第二个*表示类中任意的方法
* ..表示任意参数列表
* 类的地方也可以使用*，表示包下所有的类
*
* 3、重用切入点表达式
* //@Pointcut声明一个公共的切入点表达式
* @Pointcut("execution(* spring.aop.annotation.CalculatorImpl.*(..))")
* public void pointCut(){}
* 使用方式：@Before("pointCut()")
*
* 4、获取连接点的信息
* 在通知方法的参数位置，设置JoinPoint类型的参数，就可以获取连接点所对应的方法的信息
* //获取连接点所对应方法的签名信息
* Signature signature = joinPoint.getSignature();
* //获取连接点所对应方法的参数
* Object[] args = joinPoint.getArgs();
*
* 5、切面的优先级
* 相同目标方法上同时存在多个切面时，切面的优先级控制切面的**内外嵌套**顺序。
* 优先级高的切面：外面
* 优先级低的切面：里面
* 使用@Order注解可以控制切面的优先级：
* @Order(较小的数)：优先级高
* @Order(较大的数)：优先级低
* */

//创建切面类
@Component
@Aspect //将当前组件标识为切面
public class LoggerAspect {

    //声明公共的切入点表达式
    @Pointcut("execution(* spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}

    //@Before("execution(public int spring.aop.annotation.CalculatorImpl.add(int,int))")
    //@Before("execution(* spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法：" + signature.getName() + ",参数：" + Arrays.toString(args));

       /* System.out.println("AnnoAdvice - before1:");
        System.out.println("target object:" + args);
        System.out.println("target method:" + signature);*/
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法：" + signature.getName() + ",执行完毕");
    }

    /*@AfterReturning(value = "pointCut()",returning = "result")
    public void AfterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法：" + signature.getName() + ",结果：" + result);
    }*/

    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法：" + signature.getName() + ",异常：");
    }

    /*@Around("pointCut()")
    //环绕通知方法的返回值一定要和目标对象方法的返回值一致
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("环绕通知-->目标对象方法执行之前");
            //表示目标对象方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知-->目标对象方法返回值之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->目标对象方法出现异常时");
        } finally {
            System.out.println("环绕通知-->目标对象方法执行完毕");
        }
        return result;
    }*/
}
