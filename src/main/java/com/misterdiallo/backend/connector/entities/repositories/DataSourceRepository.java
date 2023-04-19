package com.misterdiallo.backend.connector.entities.repositories;

import com.misterdiallo.backend.connector.entities.DataSourceEntity;
import com.misterdiallo.backend.connector.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DataSourceRepository extends JpaRepository<DataSourceEntity, Long> {
}

