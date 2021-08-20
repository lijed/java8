/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何处理，而在终止操作时一次性全部处理，称为惰性求值
 **/
public class TestStreamApi {

    private static final Integer[] integers = new Integer[10];

    Random random =new Random();
    @Before
    public void setup() {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = random.nextInt(100);
        }
    }


    @Test
    public void test() {
        //中间操作
       Stream<Integer> stream =  Arrays.stream(integers).filter(x -> {
            System.out.println("filter    " + x);
            return x.compareTo(50)>= 0;
           }).limit(5);  //找到满足指定个数的原始后，就不遍历了

       // 终止操作
        stream.forEach(System.out::println);
    }
}
