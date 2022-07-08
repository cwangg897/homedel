package com.flab.homedel.dto;

import com.flab.homedel.enums.UserLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserDto {

    @NotBlank
    private String id;

    @NotBlank // (message = "이메일을 입력해주세요")
    @Email // (message = "이메일 형식을 맞춰주세요")
    private String email;

    @NotBlank// (message = "비밀번호를 입력해주세요")
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private UserLevel level;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder
    public UserDto(String id, String email, String password, String name, String phoneNumber, UserLevel level){
        this.id = id;
        this. email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.level = level;
    }
}
