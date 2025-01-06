package com.multiwarehouse.user.mapper;

import com.multiwarehouse.user.dto.UserDto;
import com.multiwarehouse.user.entity.User;

public class UserMapper {

    public static UserDto.GetUser getUserToDto(User user, UserDto.GetUser getUserDto) {
        getUserDto.setId(user.getId());
        getUserDto.setEmail(user.getEmail());
        return getUserDto;
    }

    public static User creatUserFromDto(UserDto.CreateUser createUser, User user) {
        user.setEmail(createUser.getEmail());
        user.setPassword(createUser.getPassword());
        return user;
    }
}