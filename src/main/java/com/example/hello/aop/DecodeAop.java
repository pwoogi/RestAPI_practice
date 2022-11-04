package com.example.hello.aop;

import com.example.hello.dto.Student;
import com.example.hello.ioc.Base64Enconder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.example.hello.controller..*.*(..))")
    private void cut(){

    }

    @Pointcut("@annotation(com.example.hello.annotation.Decode)")
    private void enableDecode(){

    }

    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object [] args = joinPoint.getArgs();

        for(Object arg : args){
            if(arg instanceof Student){
                Student student = Student.class.cast(arg);
                String base64Email = student.getEmail();
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");
                student.setEmail(email);
            }
        }
    }

    @AfterReturning(value = "cut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        if(returnObj instanceof Student){
            Student student = (Student) returnObj;
            String email = student.getEmail();
            String bas64Email = Base64.getEncoder().encodeToString(email.getBytes());
            student.setEmail(bas64Email);
        }

    }

}
