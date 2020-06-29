package com.springboot.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Bycrpt
 */
public class Bcrypt {

    public static String getHash(String password) {

        if ("".equals(password)) {
            return null;
        }

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

        return bcrypt.encode(password);
    }
    
}