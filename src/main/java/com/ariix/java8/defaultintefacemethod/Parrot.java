/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.defaultintefacemethod;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/16
 **/
public class Parrot implements Fly, Eat {
    @Override
    public void eat() {
        System.out.println("Parrot can eat");
    }

    @Override
    public void fly() {
        System.out.println("Parrot can fly");
    }

    @Override
    public void show() {
        System.out.println(Parrot.class.getName() + " show" );

    }

    public static void main(String[] args) {
        Eat parrot = new Parrot();
        parrot.show();
        Fly.say();


    }
}
