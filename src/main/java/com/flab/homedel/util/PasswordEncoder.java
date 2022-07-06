package com.flab.homedel.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

public class PasswordEncoder{

    public static String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean isMatch(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

}
