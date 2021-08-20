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
import sun.java2d.SurfaceDataProxy;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Streams
 *
 * 1. 创建数据源
 **/
public class TestStream {
    private static final Integer[] integers = new Integer[10];

    Random random =new Random();
    @Before
    public void setup() {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = random.nextInt(100);
        }
    }


    @Test
    public void testDatasource( ) {
        //通过collections集合提供的Stream 或者paralelStream
        List<String> list = new ArrayList<>();
        Stream<String> stringStream = list.stream();
        Stream<String> parallelStream = list.parallelStream();

        //通过Arrays中的静态方法stream()获取数组流
        Stream<Integer> stream = Arrays.stream(integers);

        //3通过stream类中的静态方法
        Stream<String> stream1 = Stream.of("jell" , "li");

        //4 创建无限流
        Stream<Integer> stream4 = Stream.iterate(1, x -> x + 5);
//        stream4.forEach(System.out::println);


        //5 创建无限流
        Random random = new Random();
        Stream<Integer> stream5 = Stream.generate(()-> random.nextInt(42000));
        stream5.forEach(System.out::println);
    }

    @Test
    public void testStreamMap() {
        System.out.println(Arrays.toString(integers));
        List<String> result = Arrays.stream(integers).filter(x-> x >50).map(x-> x + " good").collect(Collectors.toList());
        System.out.println(Arrays.asList(result));
    }
}
