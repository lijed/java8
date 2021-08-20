/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.optional;

import java.util.Optional;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/16
 **/
public class Man {
    Optional<Godness> godNess = Optional.empty();

    public Optional<Godness> getGodNess() {
        return godNess;
    }

    public void setGodNess(Optional<Godness> godNess) {
        this.godNess = godNess;
    }
}
