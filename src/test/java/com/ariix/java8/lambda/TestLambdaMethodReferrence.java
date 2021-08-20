/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.function.*;

/**
 * 一 方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”，可以理解为方法引用是Lambda表达式的另外一种表现形式
 * <p>
 * 主要有三种方式
 * <p>
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名字  ---如lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数，可以使用ClassName::method
 *
 * 注意：
 * 1. @Lambada体中调用方法的参数列表和返回值类型 要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 * 2.如lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数，可以使用ClassName::method
 *
 *
 * 二 构造器引用
 *
 * 需要注意的是构造器的参数列表要与函数式接口里抽象方法的参数列表保持一致
 *
 * 三 数组引用
 *
 * Type::new
 **/
public class TestLambdaMethodReferrence {


    //         * 对象::实例方法名
    @Test
    public void testObjectMethod() {
        PrintStream ps = System.out;
        Consumer<String> consumer = x -> ps.println(x);
        consumer.accept("Hello Lambada");
        Consumer<String> con = ps::print;

        con.accept("hello Lambada");
    }


    @Test
    public void testObjectMethod2() {
        Employee employee = new Employee();
        Supplier<String> sup = () -> employee.getName();
        System.out.println(sup.get());

        Supplier<Integer> supplier = employee::getAge;

        System.out.println(supplier.get());
    }

    @Test
    public void testStaticMethod() {
        Comparator<Integer> comparator1 = (x, y) -> x.compareTo(y);


        Comparator<Integer> comparator = Integer::compare;

        System.out.println(comparator.compare(-1, 90));
    }

    // * 类::实例方法名字
    @Test
    public void testInstanceMethod() {
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);

        BiPredicate<String, String> biPredicate1 = String::equals;

        System.out.println(biPredicate1.test("aaa", "jedli"));

    }

    public void  testConstructorRef() {
        Supplier<Employee> sup = () -> new Employee();


        Supplier<Employee> supplier = Employee::new;
        System.out.println(supplier.get());
    }

    public void  testConstructorRef1() {
        BiFunction<String, Integer , Employee> biFunction = (x, y) -> new Employee(x, y);

        BiFunction<String, Integer , Employee> biFunction1 = Employee::new;
    }


    @Test
    public void testArray() {
        Function<Integer, String[]> function = (x) -> new String[x];

        System.out.println(function.apply(10).length);

        Function<Integer, String[]> function1 = String[]::new;
        System.out.println(function1.apply(20).length);
    }
}
