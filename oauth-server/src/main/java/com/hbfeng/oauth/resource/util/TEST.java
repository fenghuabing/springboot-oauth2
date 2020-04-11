package com.hbfeng.oauth.resource.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TEST {
    public static void main(String[] args){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("secret"));
    }
}
