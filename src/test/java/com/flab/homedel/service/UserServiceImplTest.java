package com.flab.homedel.service;

import com.flab.homedel.dto.UserDto;
import com.flab.homedel.mapper.UserMapper;
import com.flab.homedel.util.PasswordEncoder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
class UserServiceImplTest {

    public UserDto userDto;

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

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
    @Rollback(value = true)
    @DisplayName("회원가입 예외 메시지 테스트")
    void signup_fail(){
        // given
        // when
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            userService.signup(userDto);
        });
        // then
        Assertions.assertEquals("이미 존재하는 아이디입니다", runtimeException.getMessage());
    }

    @Test
    @Transactional
    @Rollback(value = true)
    @DisplayName("회원가입 성공")
    void signup_success(){
        // given
        // when
        userService.signup(userDto);
        // then
        UserDto findUser = userMapper.findById(userDto.getId());
        Assertions.assertEquals(findUser.getId(), userDto.getId());
    }


}