package com.flab.homedel.mapper;

import com.flab.homedel.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insertUser(UserDto userDto);

    boolean isExistsId(String id);

    UserDto findById(String id);

}
