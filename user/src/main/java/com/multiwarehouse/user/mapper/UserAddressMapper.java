package com.multiwarehouse.user.mapper;

import com.multiwarehouse.user.dto.UserAddressDto;
import com.multiwarehouse.user.entity.UserAddress;

public class UserAddressMapper {

    public static UserAddressDto userAddressToDto(
            UserAddress userAddress, UserAddressDto userAddressDto) {
        userAddressDto.setId(userAddress.getId());
        userAddressDto.setLabel(userAddress.getLabel());
        userAddressDto.setAddress(userAddress.getAddress());
        userAddressDto.setPostalCode(userAddress.getPostalCode());
        return userAddressDto;
    }

    public static UserAddress userAddressFromDto(UserAddressDto.CreateUserAddress createUserAddress,
                                                 UserAddress userAddress) {
        userAddress.setLabel(createUserAddress.getLabel());
        userAddress.setAddress(createUserAddress.getAddress());
        userAddress.setPostalCode(createUserAddress.getPostalCode());
        return userAddress;
    }
}