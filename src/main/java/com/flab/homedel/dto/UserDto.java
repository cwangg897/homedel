package com.flab.homedel.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserDto {

    private String id;
    private String email;
    private String password;
    private String name;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    //id varchar(50) PK
    //email varchar(50)
    //password varchar(255)
    //name varchar(20)
    //phone_number varchar(50)
    //created_at timestamp
    //modified_at timestamp

    @Builder
    public UserDto(String id, String email, String password, String name, String phoneNumber){
        this.id = id;
        this. email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


}
