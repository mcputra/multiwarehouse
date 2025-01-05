package com.multiwarehouse.user.repository;

import com.multiwarehouse.user.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, UUID> {

    Optional<UserAddress> findByUserId(UUID userId);
}
