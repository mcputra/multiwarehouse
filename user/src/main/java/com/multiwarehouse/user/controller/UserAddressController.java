package com.multiwarehouse.user.controller;

import com.multiwarehouse.user.dto.ResponseDto;
import com.multiwarehouse.user.dto.UserAddressDto;
import com.multiwarehouse.user.service.IUserAddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path="/api/user-address", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class UserAddressController {

    private IUserAddressService iUserAddressService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUserAddress(@RequestBody UserAddressDto.CreateUserAddress createUserAddress) {
        iUserAddressService.createUserAddress(createUserAddress);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "User address created successfully"));
    }

    @GetMapping("/get")
    public ResponseEntity<UserAddressDto.GetUserAddress> getUserAddress(@RequestParam UUID id) {
        UserAddressDto.GetUserAddress userAddress = iUserAddressService.getUserAddress(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userAddress);
    }

}