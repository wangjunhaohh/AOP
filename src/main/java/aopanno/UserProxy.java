package aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)//数值越小优先级越高
//增强类
public class UserProxy {

    //相同切入点抽取
    @Pointcut(value = "execution(* aopanno.User.add(..))")
    public void pointdemo(){

    }


    @Before(value = "pointdemo()")
    public void before(){
        System.out.println("before...");
    }
    //最终通知
    @After(value = "execution(* aopanno.User.add(..))")
    public void after(){
        System.out.println("after...");
    }
    //异常通知
    @AfterThrowing(value = "execution(* aopanno.User.add(..))")
    public void afterthrowing() {
        System.out.println("afterthrowing...");

    }
    //环绕通知
    @Around(value = "execution(* aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundbefore...");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("aroundafter...");
    }
    //后置通知
    @AfterReturning(value = "execution(* aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning...");

    }
}
