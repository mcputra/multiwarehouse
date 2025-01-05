package com.multiwarehouse.user.mapper;

import com.multiwarehouse.user.dto.UserDto;
import com.multiwarehouse.user.entity.User;

public class UserMapper {

    public static UserDto.GetUser getUserToDto(User user, UserDto.GetUser getUser) {
        getUser.setId(user.getId());
        getUser.setEmail(user.getEmail());
        return getUser;
    }

    public static User creatUserFromDto(UserDto.CreateUser createUser, User user) {
        user.setEmail(createUser.getEmail());
        user.setPassword(createUser.getPassword());
        return user;
    }
}