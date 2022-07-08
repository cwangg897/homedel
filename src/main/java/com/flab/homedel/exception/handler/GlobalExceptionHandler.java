package com.flab.homedel.exception.handler;

import com.flab.homedel.exception.SignUpException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){
        log.info("Http Method : {}  URI : {}",request.getMethod(),request.getRequestURI());
        return getBadResponse("정보가 올바르지 않습니다");
    }


    @ExceptionHandler(SignUpException.class)
    public ResponseEntity<String> handleSignUpException(SignUpException e, HttpServletRequest request){
        log.info("Http Method : {}  URI : {}",request.getMethod(),request.getRequestURI());
        return getBadResponse(e.getMessage());
    }

    private ResponseEntity<String> getBadResponse(String msg){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }
}
