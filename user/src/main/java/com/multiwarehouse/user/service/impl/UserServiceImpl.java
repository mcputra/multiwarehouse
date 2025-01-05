package com.multiwarehouse.user.service.impl;

import com.multiwarehouse.user.dto.UserAddressDto;
import com.multiwarehouse.user.dto.UserDto;
import com.multiwarehouse.user.entity.User;
import com.multiwarehouse.user.entity.UserAddress;
import com.multiwarehouse.user.exception.ResourceNotFoundException;
import com.multiwarehouse.user.exception.UserAlreadyExistsException;
import com.multiwarehouse.user.mapper.UserAddressMapper;
import com.multiwarehouse.user.mapper.UserMapper;
import com.multiwarehouse.user.repository.UserAddressRepository;
import com.multiwarehouse.user.repository.UserRepository;
import com.multiwarehouse.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserAddressRepository userAddressRepository;
    private UserRepository userRepository;

    @Override
    public void createUser(UserDto.CreateUser createUser) {
        User user = UserMapper.creatUserFromDto(createUser, new User());
        Optional<User> existingUser = userRepository.findByEmail(createUser.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User already exists" + createUser.getEmail());
        }
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public UserDto.GetUser getUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
        UserAddress userAddress = userAddressRepository.findByUserId(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("UserAddress", "userId", user.getId().toString()));

        UserDto.GetUser userDto = UserMapper.getUserToDto(user, new UserDto.GetUser());
        userDto.setUserAddressDto(UserAddressMapper.userAddressToDto(userAddress, new UserAddressDto()));

        return userDto;
    }
}
