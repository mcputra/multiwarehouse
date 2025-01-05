package com.multiwarehouse.user.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {

    @Data
    public static class CreateUser {
        private String email;
        private String password;
    }

    @Data
    public static class GetUser {
        private UUID id;
        private String email;
        private UserAddressDto userAddressDto;
    }
}
