/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.lambda;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/13
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String name;
    private Integer age;
    private Double salary;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
