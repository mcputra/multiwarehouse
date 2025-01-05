package com.multiwarehouse.user.mapper;

import com.multiwarehouse.user.dto.UserAddressDto;
import com.multiwarehouse.user.entity.UserAddress;

public class UserAddressMapper {

    public static UserAddressDto.CreateUserAddress userAddressToDto(
            UserAddress userAddress, UserAddressDto.CreateUserAddress createUserAddress) {
        createUserAddress.setLabel(userAddress.getLabel());
        createUserAddress.setAddress(userAddress.getAddress());
        createUserAddress.setPostalCode(userAddress.getPostalCode());
        return createUserAddress;
    }

    public static UserAddress userAddressFromDto(UserAddressDto.CreateUserAddress createUserAddress,
                                                 UserAddress userAddress) {
        userAddress.setLabel(createUserAddress.getLabel());
        userAddress.setAddress(createUserAddress.getAddress());
        userAddress.setPostalCode(createUserAddress.getPostalCode());
        return userAddress;
    }
}