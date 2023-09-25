package com.lewis.recruit.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Random;
import java.util.UUID;

public class SaltUtils {
    //自定义的生成盐值的方法
    public static String getSalt(int n){
        char [] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!@#$%^&*()_+".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char chars1 = chars[new Random().nextInt(chars.length)];
            stringBuilder.append(chars1);
        }
        return stringBuilder.toString();
    }

    public static String getSaltByUUID(int n){
        String salt="";
        String uuid = UUID.randomUUID().toString();
        String replace = uuid.replace("-", "");
        for (int i = 0; i < n; i++) {
            char s = replace.charAt(new Random().nextInt(replace.length()));
            salt += s;
        }
        return salt;
    }
    public static void main(String[] args) {

        Md5Hash md5Hash = new Md5Hash("123123","Okc1",1024);
        System.out.println(md5Hash.toHex());
    }
}
