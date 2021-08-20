/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/6/2
 **/
public class GroupNameExpTest {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(?<segment>/?.*)");
        Matcher matcher = p.matcher("/1aaa1aaaa/abbb");
        System.out.println(matcher.groupCount());
        while(matcher.find()) {
            System.out.println(matcher.group("segment"));
        }
        matcher.reset();
        while(matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
