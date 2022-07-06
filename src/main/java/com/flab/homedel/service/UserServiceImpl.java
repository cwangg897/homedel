package com.flab.homedel.service;

import com.flab.homedel.dto.UserDto;
import com.flab.homedel.mapper.UserMapper;
import com.flab.homedel.util.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;


    @Override
    public void signup(UserDto userDto) {
        if(userMapper.isExistsId(userDto.getId())){
            throw new RuntimeException("이미 존재하는 아이디입니다"); // 예외 내가 직접커스텀하기
        }

        UserDto insertUser = UserDto.builder()
                .id(userDto.getId())
                .password(PasswordEncoder.encrypt(userDto.getPassword()))
                .email(userDto.getEmail())
                .name(userDto.getName())
                .phoneNumber(userDto.getPhoneNumber())
                .build();

        userMapper.insertUser(insertUser);
    }




}
