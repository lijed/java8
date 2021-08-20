/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.optional;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/16
 **/
public class OptionalUsageTest {
    public static void main(String[] args) {
        Man man = new Man();

        Godness godness = man.getGodNess().orElseGet(()-> new Godness(("Defualt")));
        System.out.println(godness.toString());
    }
}
