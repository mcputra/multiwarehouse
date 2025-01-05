package com.multiwarehouse.user.controller;

import com.multiwarehouse.user.dto.ResponseDto;
import com.multiwarehouse.user.dto.UserDto;
import com.multiwarehouse.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/user", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class UserController {

    private IUserService iUserService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUser(@RequestBody UserDto.CreateUser createUser) {
        iUserService.createUser(createUser);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "User created successfully"));
    }
}