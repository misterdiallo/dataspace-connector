package com.misterdiallo.backend.connector.entities.repositories;

import com.misterdiallo.backend.connector.entities.DataSetEntity;
import com.misterdiallo.backend.connector.entities.DataSourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DataSetRepository extends JpaRepository<DataSetEntity, Long> {
}

