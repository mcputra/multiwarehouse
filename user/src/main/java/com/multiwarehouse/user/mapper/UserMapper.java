package com.multiwarehouse.user.mapper;

import com.multiwarehouse.user.dto.UserDto;
import com.multiwarehouse.user.entity.User;

public class UserMapper {

    public static UserDto.CreateUser userToDto(User user, UserDto.CreateUser createUser) {
        createUser.setEmail(user.getEmail());
        createUser.setPassword(user.getPassword());
        return createUser;
    }

    public static User userFromDto(UserDto.CreateUser createUser, User user) {
        user.setEmail(createUser.getEmail());
        user.setPassword(createUser.getPassword());
        return user;
    }
}