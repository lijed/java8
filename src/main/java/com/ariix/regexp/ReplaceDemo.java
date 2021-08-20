/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.regexp;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/6/2
 **/
public class ReplaceDemo {
    public static void main(String[] args) {
        String str = "aa文字1bb哈哈cc测试dx，测试字符串aa1234bb";

        // 替换aa、bb之间的字符串为 "成功"
        String str1 = str.replaceAll("aa.*?bb", "aa成功bb");
        System.out.println(str1);

        // 替换aa、bb之间的字符串为 "成功"
        String str2 = str.replaceAll("(aa).*?(bb)", "$1成功$2");
        System.out.println(str2);

        // 替换小写字母之间的字符串为 "成功"
        str = "aaaaffaaa文字1aabb哈哈cc测试dx，测试字符串aa1234bb";
        String str3 = str.replaceAll("([a-z]+).*?([a-z]+)", "$1成功$2");
        System.out.println(str3);

         str3 = str.replaceAll("([a-z]+).*?([a-z]+)", "null");
        System.out.println(str3);
    }
}
