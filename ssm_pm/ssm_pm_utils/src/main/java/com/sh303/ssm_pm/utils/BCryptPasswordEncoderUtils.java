package com.sh303.ssm_pm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String s = BCryptPasswordEncoderUtils.encodePassword("123");
        System.out.println(s);
        System.out.println(s.length());
    }
}
