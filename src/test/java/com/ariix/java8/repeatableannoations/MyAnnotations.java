package com.ariix.java8.repeatableannoations;


import java.lang.annotation.*;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/20
 **/

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations {

    MyAnnotation[] value();
}
