package com.multiwarehouse.user.mapper;

import com.multiwarehouse.user.dto.UserAddressDto;
import com.multiwarehouse.user.entity.UserAddress;
import com.multiwarehouse.user.repository.UserRepository;

public class UserAddressMapper {

    private UserRepository userRepository;

    public static UserAddressDto.GetUserAddress getUserAddressToDto(
            UserAddress userAddress, UserAddressDto.GetUserAddress getUserAddressDto) {

        getUserAddressDto.setId(userAddress.getId());
        getUserAddressDto.setUserId(userAddress.getUser().getId());
        getUserAddressDto.setLabel(userAddress.getLabel());
        getUserAddressDto.setAddress(userAddress.getAddress());
        getUserAddressDto.setPostalCode(userAddress.getPostalCode());
        return getUserAddressDto;
    }

    public static UserAddress createUserAddressFromDto(
            UserAddressDto.CreateUserAddress createUserAddress, UserAddress userAddress) {

        userAddress.setLabel(createUserAddress.getLabel());
        userAddress.setAddress(createUserAddress.getAddress());
        userAddress.setPostalCode(createUserAddress.getPostalCode());
        return userAddress;
    }

}