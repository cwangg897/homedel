package com.flab.homedel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flab.homedel.dto.UserDto;
import com.flab.homedel.util.PasswordEncoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.codec.cbor.Jackson2CborEncoder;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    private UserDto userDto;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void initEach(){
        System.out.println("beforeEach start");
        //test setup code
        String id = "test1";
        String password = "1111";
        String name = "테스트";
        String phoneNumber = "010-1111-1111";
        String email = "test@naver.com";

        userDto = UserDto.builder()
                .id(id)
                .password(PasswordEncoder.encrypt(password))
                .phoneNumber(phoneNumber)
                .name(name)
                .email(email)
                .build();
    }

    @Test
    @Transactional
    @DisplayName("회원가입")
    void signup() throws Exception {
        // given
        String json = objectMapper.writeValueAsString(userDto);
        // when
        mockMvc.perform(post("/user/signup").contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andDo(print());
    }

}