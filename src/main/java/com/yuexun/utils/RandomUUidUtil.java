package com.yuexun.utils;

import java.util.Random;

/**
 * @author 曾惠君
 * @date 2018/10/31
 * @time 9:27
 */
public class RandomUUidUtil {
    //随机密码生成
    public static String makeRandomUUid(int len){
        char charr[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~!@#$%^&*.?".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int x = 0; x < len; ++x) {
            sb.append(charr[r.nextInt(charr.length)]);
        }
        return sb.toString();
    }
}
