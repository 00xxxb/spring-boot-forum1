package com.lfd.aspect;

import com.lfd.service.IndexService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class MyAspect {

    @Autowired
    IndexService service;

    @Pointcut("@annotation(com.lfd.annotation.MyAnnotation)")
    public void MyMethod( ) {
    }

    @Around("MyMethod()")
    public Object verification(ProceedingJoinPoint pjp)throws Throwable{
        //获取参数
        Object[] args = pjp.getArgs();
        HttpSession session = (HttpSession) args[0];

         if(session.getAttribute("s_status").equals(1)){
//             System.out.println("验证成功");

             return pjp.proceed();
         }else{
//             System.out.println("验证失败");
             return "redirect:kh";
         }

    }
}


