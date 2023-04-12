package com.misterdiallo.backend.connector.services;

import com.misterdiallo.backend.connector.entities.StorageEntity;

import java.util.List;


public interface StorageService {

    List<StorageEntity> findAll();

   StorageEntity findById(Long id);

    public StorageEntity save(StorageEntity resource);

    public void deleteById(Long id);
}
