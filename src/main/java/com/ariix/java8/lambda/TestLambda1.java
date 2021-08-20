/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/13
 **/
public class TestLambda1 {

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

    private interface Predicate<T> {
        boolean test(T t);
    }

    public static void main(String[] args) {
        filterSalaryMorethan5000(p -> {
            if (p.getSalary() >= 5000) {
                return true;
            }
            return false;
        });
    }

    public static void filterSalaryMorethan5000(Predicate<Employee> t) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : itDeparet) {
            if (t.test(employee)) {
                emps.add(employee);
            }
        }

        System.out.println(emps.toString());
    }
}
