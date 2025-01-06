package com.multiwarehouse.user.service.impl;

import com.multiwarehouse.user.dto.UserDto;
import com.multiwarehouse.user.entity.User;
import com.multiwarehouse.user.exception.ResourceNotFoundException;
import com.multiwarehouse.user.exception.UserAlreadyExistsException;
import com.multiwarehouse.user.mapper.UserMapper;
import com.multiwarehouse.user.repository.UserRepository;
import com.multiwarehouse.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    @Override
    public void createUser(UserDto.CreateUser createUser) {
        User user = UserMapper.creatUserFromDto(createUser, new User());
        Optional<User> existingUser = userRepository.findByEmail(createUser.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User already exists with email: " + createUser.getEmail());
        }
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public UserDto.GetUser getUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));

        return UserMapper.getUserToDto(user, new UserDto.GetUser());
    }

    @Override
    public boolean updateUser(UserDto.CreateUser userDto) {
        String id = userDto.getId().toString();

        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        UserMapper.creatUserFromDto(userDto, user);
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);

        return true;
    }

    @Override
    public boolean deleteUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
        userRepository.delete(user);
        return true;
    }

}
