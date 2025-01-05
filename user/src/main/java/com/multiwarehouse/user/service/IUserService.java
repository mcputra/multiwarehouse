package com.multiwarehouse.user.service;

import com.multiwarehouse.user.dto.UserDto;

public interface IUserService {
    void createUser(UserDto.CreateUser createUser);

    UserDto.GetUser getUser(String email);
}