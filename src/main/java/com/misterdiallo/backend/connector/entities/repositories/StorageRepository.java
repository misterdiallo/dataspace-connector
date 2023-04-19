package com.misterdiallo.backend.connector.entities.repositories;

import com.misterdiallo.backend.connector.entities.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<StorageEntity, Long> {
}
