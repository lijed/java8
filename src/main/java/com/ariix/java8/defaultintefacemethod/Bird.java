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
public class Bird implements Fly {
    @Override
    public void fly() {
        System.out.println("Bird can fly");
    }

    @Override
    public void show() {
        System.out.println(Bird.class.getName() + " show ");
    }


}
