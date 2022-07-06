package com.flab.homedel.controller;


import com.flab.homedel.dto.UserDto;
import com.flab.homedel.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final ResponseEntity REQUEST_OK = new ResponseEntity(HttpStatus.OK);
    private final ResponseEntity REQUEST_CONFLICT = new ResponseEntity(HttpStatus.BAD_REQUEST);

    private final UserService userService;

    // dto에 valid 추가하기
    @PostMapping("/user/signup")
    public ResponseEntity<Void> signup(@RequestBody UserDto userDto){
//        log.info("signup : {}", userDto.getId()); // 로그에 무슨메시지를 넣어야좋을가??
        userService.signup(userDto);
        return REQUEST_OK;
    }



}
