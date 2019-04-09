package com.fxb.annotation;

import java.lang.annotation.*;

@Documented    // 表明这个注解应该被javadoc工具记录，默认，javadoc是不包括注解的
@Retention(RetentionPolicy.RUNTIME)    //这个注解是保留说明，也就是说表明这个租借锁注解的类能够在哪里保留
@Target(ElementType.METHOD)  //表明这个注解能够作用的范围
public @interface MyAnnotation {

}