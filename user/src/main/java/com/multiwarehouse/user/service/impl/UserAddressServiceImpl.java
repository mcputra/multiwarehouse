package com.multiwarehouse.user.service.impl;

import com.multiwarehouse.user.dto.UserAddressDto;
import com.multiwarehouse.user.entity.User;
import com.multiwarehouse.user.entity.UserAddress;
import com.multiwarehouse.user.exception.ResourceNotFoundException;
import com.multiwarehouse.user.mapper.UserAddressMapper;
import com.multiwarehouse.user.repository.UserAddressRepository;
import com.multiwarehouse.user.repository.UserRepository;
import com.multiwarehouse.user.service.IUserAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserAddressServiceImpl implements IUserAddressService {

    private UserAddressRepository userAddressRepository;
    private UserRepository userRepository;

    @Override
    public void createUserAddress(UserAddressDto.CreateUserAddress createUserAddress) {
        UserAddress userAddress = UserAddressMapper.createUserAddressFromDto(createUserAddress, new UserAddress());
        userAddress.setCreatedAt(LocalDateTime.now());

        Optional<User> optionalUser = userRepository.findById(createUserAddress.getUserId());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        userAddress.setUser(optionalUser.get());

        userAddressRepository.save(userAddress);
    }

    @Override
    public UserAddressDto.GetUserAddress getUserAddress(UUID id) {
        UserAddress userAddress = userAddressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserAddress", "id", id.toString()));

        return UserAddressMapper.getUserAddressToDto(userAddress, new UserAddressDto.GetUserAddress());
    }

    @Override
    public boolean updateUserAddress(UserAddressDto.CreateUserAddress addressDto) {
        String id = addressDto.getId().toString();

        UserAddress userAddress = userAddressRepository.findById(addressDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("UserAddress", "id", id));

        UserAddressMapper.createUserAddressFromDto(addressDto, userAddress);
        userAddress.setUpdatedAt(LocalDateTime.now());
        userAddressRepository.save(userAddress);

        return true;
    }

    @Override
    public boolean deleteUserAddress(UUID id) {
        UserAddress userAddress = userAddressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserAddress", "id", id.toString()));
        userAddressRepository.delete(userAddress);
        return true;
    }
}
