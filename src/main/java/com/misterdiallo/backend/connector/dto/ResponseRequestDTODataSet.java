package com.misterdiallo.backend.connector.dto;

import com.misterdiallo.backend.connector.entities.DataSourceEntity;
import com.misterdiallo.backend.connector.entities.repositories.DataSourceRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class ResponseRequestDTODataSet {
    private long id;
    private String name;
    private DataSourceEntity dataSource;


}
