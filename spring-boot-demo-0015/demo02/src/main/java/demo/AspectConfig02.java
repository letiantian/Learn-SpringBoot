package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class AspectConfig02 {

    // 定义切点（切入位置）
    @Pointcut("execution(* demo.SayHello.*(..))")
    private void pointcut(){}


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("AspectConfig02: 我是环绕通知前....");
        //执行目标函数
        Object obj= (Object) joinPoint.proceed();
        System.out.println("AspectConfig02: 我是环绕通知后....");
        if (obj instanceof String) {
            return "AspectConfig02: 我被切面修改了";
        }
        return obj;
    }

}
