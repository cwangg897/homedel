package com.flab.homedel.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordEncoderTest {

    private final String password = "1111";

    @Test
    void encrypt(){
        // given
        // when
        String encrypt = PasswordEncoder.encrypt(password);
        // then
        Assertions.assertNotEquals(password, encrypt);
    }

    @Test
    void match(){
        // given
        String encrypt = PasswordEncoder.encrypt(password);
        // when
        boolean match = PasswordEncoder.isMatch(password, encrypt);
        // then
        Assertions.assertEquals(true, match);
    }

}