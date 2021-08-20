package com.ariix.java8.repeatableannoations;

import java.lang.annotation.*;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/20
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
//Repeatable指定容器注解，它可以装有需要重复的注解
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
     String value() default "My Annotation";
}
