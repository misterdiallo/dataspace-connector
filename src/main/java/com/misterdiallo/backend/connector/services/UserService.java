package com.misterdiallo.backend.connector.services;

import com.misterdiallo.backend.connector.entities.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity findByEmail(String email);
    List<UserEntity> getAllUsers();
    UserEntity saveUser(UserEntity user);
    void deleteUser(Long id);
}
