/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.uuid;

import java.util.UUID;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/4/29
 **/
public class UUIDApp {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());  //UUID 一共32位

        System.out.println(UUID.nameUUIDFromBytes("jedli".getBytes()));
        System.out.println(UUID.fromString("1-2-3-4-5"));
    }
}
