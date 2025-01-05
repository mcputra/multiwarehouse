package com.multiwarehouse.user.service;

import com.multiwarehouse.user.dto.UserAddressDto;

public interface IUserAddressService {
    void createUserAddress(UserAddressDto.CreateUserAddress createUserAddress);
}