/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.optional;

import com.ariix.java8.lambda.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/16
 **/
public class OptionalTest {

    @Test
    public void testOf() {
       Optional<Integer> result =  Optional.of(1);
        System.out.println("是否有值" +  result.isPresent());
    }

    @Test
    public void testElse() {
       Optional<Integer> result =  Optional.empty();
        System.out.println("是否有值" +  result.isPresent() + ",  如果没有值默认为"+ result.orElse(18));
    }


    @Test
    public void testOfNullable() {
        //允许把控制方法容器里
        Optional<Employee> itWorker =  Optional.ofNullable(null);
        System.out.println("是否有IT 部分员工参与" + itWorker.isPresent());
    }

    private Optional<Employee> getItWorkder() {
        return  Optional.ofNullable(null);
    }

    @Test
    public void testOrEleseGet () {
        Optional<Employee> itWorker = getItWorkder();
        if (itWorker.isPresent()) {
            System.out.println(itWorker.toString() + " joins");
        } else {
            Employee employee = itWorker.orElseGet(() -> new Employee("jed", 52, 9865.85));
            System.out.println(employee.toString() + " joins ");
        }
    }


    @Test
    public void testFlatmap() {
        Optional<String> employee  = Optional.of(new Employee("jed", 52, 9865.85))
                .flatMap(employee1 -> Optional.of(employee1.getName()));

        System.out.println(employee.get());

        Optional<Employee> optionalEmployee = Optional.empty();

        Optional<String> mvpName = optionalEmployee.flatMap(employee1 -> Optional.of(employee1.getName()));

        System.out.println(mvpName.orElse("No One is MVP"));
    }
}
