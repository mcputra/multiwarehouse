package com.multiwarehouse.user.dto;

import lombok.Data;

@Data
public class UserDto {

    @Data
    public static class CreateUser {
        private String email;
        private String password;
    }

    private String email;
}
