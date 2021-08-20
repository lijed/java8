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
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;


/**
 * Description:
 *
 * lamba 表达式 “->”  箭头表达式，lambda 操作符， 将lambda表达式拆分成两部分
 *
 * 左侧：lambda 表达式的操作数
 * 右侧：表达式中锁执行的功能，即lambda提
 *
 * 语法1：无参数，无返回值
 * () -> System.out.print("Hellow Lambda");
 *
 * 语法2：一个参数，并且无返回值
 * (x) -> System.out.print(x);
 *
 * 语法3: 一个参数，小括号可以不写
 *   x -> System.out.print(x);
 *
 * 语法4: 两个或者多个参数，多条语句必须放置{}内
 *  *   x -> System.out.print(x);
 *
 *
 * 语法5：若lambda体中只有一条语句，return 和大括号都可以不用谢
 * comparator = (x, y) ->   x.compareTo(y);
 *
 * 语法6： Lambda 表达式的参数列表的数据类型可以省略不写，因为jvm编译器通过上下文推断出数据类型，即 这就是类型推断
 *
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 *
 * 二：函数式接口 支持lambda表达式
 * @Author: Administrator
 * Created: 2021/8/13
 **/
public class TestLambda2 {
    public final static List<Employee> itDeparet = Arrays.asList(
            new Employee("李四", 32, 9999.99),
            new Employee("张丽", 12, 9999.99),
            new Employee("王三", 30, 1999.99),
            new Employee("赵四", 32, 2999.99),
            new Employee("李贴", 48, 3999.99),
            new Employee("李里", 48, 4999.99),
            new Employee("李名", 48, 9699.99),
            new Employee("李四一", 48, 7999.99),
            new Employee("李四啊", 48, 9999.99),
            new Employee("赵武", 52, 999.99),
            new Employee("张三", 48, 1999.99),
            new Employee("李五", 48, 2999.99),
            new Employee("李三", 48, 5699.99)
    );



    @Test
    public void test1() {
        int i = 0; //jdk1.7 之前必须是final的
        Runnable r1 = () -> {
            System.out.println("Hello lambada" + i);
        };
        r1.run();
    }


    @Test
    public void test2() {
        Consumer consumer = i -> System.out.println(i);
        consumer.accept(1);

        consumer = (i) -> System.out.println(i);
        consumer.accept(1);

        consumer = (i) -> {System.out.println(i);};
        consumer.accept(1);
    }


    @Test
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> {
            return x.compareTo(y)  ;
        };

        System.out.println(comparator.compare(1, 2));

        comparator = (x, y) ->   x.compareTo(y);
        System.out.println(comparator.compare(2, 2));
    }


    @Test
    public void test4() {
        Comparator<Integer> comparator = (Integer x, Integer y)->x.compareTo(y);
    }


    @Test
    public void test5() {
        MyFunc myFunc = x-> 2 * x;
        System.out.println(test5(1, myFunc));

        System.out.println(test5(1, (x)-> 2 * x));
    }

    public int test5(int opr, MyFunc myFunc) {
        return opr + myFunc.calculate(opr);
    }

}
