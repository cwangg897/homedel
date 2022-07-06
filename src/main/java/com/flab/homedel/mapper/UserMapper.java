package com.flab.homedel.mapper;

import com.flab.homedel.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    boolean isExistsId(String id); //

    void insertUser(UserDto userDto); //

    UserDto findById(String id); //

}
