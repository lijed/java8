/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.repeatableannoations;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/20
 **/
public class TestRepeatableAnnotation {



    @MyAnnotation(value = "hello")
    @MyAnnotation(value = "jed li")
    @MyAnnotation(value = "hello")
    public void show() {

    }

    @Test
    public void testRepeatableAnnotation() throws NoSuchMethodException {
        final Method show = TestRepeatableAnnotation.class.getMethod("show");
        final MyAnnotation[] annotationsByType = show.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : annotationsByType) {
            System.out.println(myAnnotation.value());
        }
    }
}
