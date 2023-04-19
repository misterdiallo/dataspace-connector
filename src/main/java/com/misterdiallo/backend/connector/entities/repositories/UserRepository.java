package com.misterdiallo.backend.connector.entities.repositories;

import com.misterdiallo.backend.connector.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}

