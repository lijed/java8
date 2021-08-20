/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置的四大函数是接口
 * <p>
 * 1. Consumer<T>  消费型接口
 * void accept(T t)
 * 2. Supplier<T> 供给型接口
 * T get();
 * <p>
 * 3.Function<T,R> 函数式接口
 * R apply(T t)
 * 4.  Predicate<T> 断言型接口
 * boolean test(T t);
 */
public class TestLambda4 {

    //Consumer<T>  消费型接口
    @Test
    public void test() {
        happy(100000d, x -> System.out.println("购物 花了" + x + "元"));
    }


    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }


    public List<Integer> getNumList(int number, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            list.add(supplier.get());
        }

        return list;
    }

    // * 2. Supplier<T> 供给型接口
    @Test
    public void test2() {
        Random random = new Random();
        List<Integer> numbers = getNumList(20, () -> {
            return random.nextInt(100);
        });

        System.out.println(numbers);
    }


//     * 3.Function<T,R> 函数式接口

    public Integer strHandler(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    @Test
    public void test3() {
        Integer length = strHandler("aaaaaaaaaaaa", x -> x.length());
        System.out.println(length);
    }


    //     * 4.  Predicate<T> 断言型接口
    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        List<String> resultList = new ArrayList<>();

        for (String s : list) {
            if (predicate.test(s)) {
                resultList.add(s);
            }
        }
        return resultList;
    }

    @Test
    public void testPredicate() {

        List<String> list = new ArrayList<>();
        list.add("happy");
        list.add("ajiyy");
        list.add("jp");
        List<String> filterList = filterStr(list, x -> x.contains("a"));
        System.out.println(filterList);
    }
}
