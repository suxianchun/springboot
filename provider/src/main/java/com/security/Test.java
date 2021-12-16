package com.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

    public static void main(String args[]){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("1234");
        //String password2 = bCryptPasswordEncoder.encode("admin");
        System.out.println(password);
        //System.out.println(password2);
    }
}
