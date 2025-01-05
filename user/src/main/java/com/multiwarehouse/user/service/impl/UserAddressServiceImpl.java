package com.multiwarehouse.user.service.impl;

import com.multiwarehouse.user.dto.UserAddressDto;
import com.multiwarehouse.user.entity.User;
import com.multiwarehouse.user.entity.UserAddress;
import com.multiwarehouse.user.mapper.UserAddressMapper;
import com.multiwarehouse.user.repository.UserAddressRepository;
import com.multiwarehouse.user.repository.UserRepository;
import com.multiwarehouse.user.service.IUserAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserAddressServiceImpl implements IUserAddressService {

    private UserAddressRepository userAddressRepository;
    private UserRepository userRepository;

    @Override
    public void createUserAddress(UserAddressDto.CreateUserAddress createUserAddress) {
        UserAddress userAddress = UserAddressMapper.userAddressFromDto(createUserAddress, new UserAddress());
        userAddress.setCreatedAt(LocalDateTime.now());

        Optional<User> optionalUser = userRepository.findById(createUserAddress.getUserId());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        userAddress.setUser(optionalUser.get());

        userAddressRepository.save(userAddress);
    }
}
