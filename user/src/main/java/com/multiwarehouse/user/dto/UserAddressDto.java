package com.multiwarehouse.user.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserAddressDto {

    @Data
    public static class CreateUserAddress {
        private UUID userId;
        private String label;
        private String address;
        private String postalCode;
    }

    @Data
    public static class GetUserAddress {
        private UUID id;
        private UUID userId;
        private String label;
        private String address;
        private String postalCode;
    }
}
