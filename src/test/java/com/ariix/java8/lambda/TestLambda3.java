/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/14
 **/
public class TestLambda3 {
    public final static List<Employee> itDeparet = Arrays.asList(
            new Employee("李赛", 32, 9999.99),
            new Employee("张三", 12, 9999.99),
            new Employee("在啊", 30, 1999.99),
            new Employee("打击", 32, 2999.99),
            new Employee("王五", 48, 3999.99),
            new Employee("赵柳", 48, 4999.99),
            new Employee("爱壶", 48, 9699.99),
            new Employee("士大夫һ", 48, 7999.99),
            new Employee("阿斯顿发", 48, 9999.99),
            new Employee("儿", 52, 999.99),
            new Employee("咋", 48, 1999.99),
            new Employee("撒旦法", 48, 2999.99),
            new Employee("儿啊", 48, 5699.99)
    );


    @Test
    public void test() {
        Collections.sort(itDeparet, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e1.getName());
            } else {
                return e1.getAge().compareTo(e2.getAge());
            }
        });

        System.out.println(itDeparet);
    }


    //用户处理字符串的方案
    public String strHandler(String str, StringFunction stringFunction) {
        return stringFunction.getValue(str);
    }

    @Test
    public void test2() {
        StringFunction stringFunction = x -> {
            if (x == null) {
                return x;
            }
            x = x.toUpperCase();
            char[] chars = x.toCharArray();
            if (x.length() <2) {
                return  x;
            } else if (x.length() < 4) {
                return x.substring(0,1) + x.substring(2);
            } else {
                return  x.substring(0,1) + x.substring(2,3) + x.substring(4);
            }
        };

        System.out.println(strHandler("abcd  ", x-> x.trim()));
        System.out.println(strHandler("abcd", stringFunction));
        System.out.println(strHandler("ac", stringFunction));
        System.out.println(strHandler("acbcddd", stringFunction));
    }


    @Test
    public void test3() {
        op(200L,  100L, (x, y) -> x + y);
        op(200L, 100L, (x,y) -> x*y);
    }
    public void op (Long op1, Long op2, CalculatorFunc<Long, Long> calculatorFunc) {
        System.out.println(calculatorFunc.op(op1, op2));
    }

}
