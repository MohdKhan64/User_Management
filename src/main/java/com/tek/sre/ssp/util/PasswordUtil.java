package com.tek.sre.ssp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtil {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static final String getHashValue(String inputText) {
        return passwordEncoder.encode(inputText);
    }
}
