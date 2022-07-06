package com.flab.homedel.dto;

import com.flab.homedel.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserDtoTest {

    @Test
    @DisplayName("UserDto 테스트-성공")
    void createUserDto_success(){
        // given
        String id = "cwg1";
        String password = "1111";
        String name = "최왕규";
        String phoneNumber = "010-1111-1111";
        String email = "cwg@naver.com";

        UserDto userDto = UserDto.builder()
                .id(id)
                .password(password)
                .phoneNumber(phoneNumber)
                .name(name)
                .email(email)
                .build();
        // when
        String getId = userDto.getId();
        // then
        Assertions.assertEquals(getId, id);
    }

}