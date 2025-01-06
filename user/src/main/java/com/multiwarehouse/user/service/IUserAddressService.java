package com.multiwarehouse.user.service;

import com.multiwarehouse.user.dto.UserAddressDto;

import java.util.UUID;

public interface IUserAddressService {

    void createUserAddress(UserAddressDto.CreateUserAddress createUserAddress);

    UserAddressDto.GetUserAddress getUserAddress(UUID id);

}