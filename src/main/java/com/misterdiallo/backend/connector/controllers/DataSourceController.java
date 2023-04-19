package com.misterdiallo.backend.connector.controllers;

import com.misterdiallo.backend.connector.entities.DataSetEntity;
import com.misterdiallo.backend.connector.entities.DataSourceEntity;
import com.misterdiallo.backend.connector.entities.repositories.DataSetRepository;
import com.misterdiallo.backend.connector.entities.repositories.DataSourceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v0/api/data-sources")
public class DataSourceController {
    private final DataSourceRepository dataSourceRepository;

    @GetMapping()
    public List<DataSourceEntity> getAllDataSources() {
        return dataSourceRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<DataSourceEntity> getDataSourceById(@PathVariable(value = "id") Long dataSourceId) {
        Optional<DataSourceEntity> dataSource = dataSourceRepository.findById(dataSourceId);
        return dataSource.map(dataSourceEntity -> ResponseEntity.ok().body(dataSourceEntity)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public DataSourceEntity createDataSource(@Valid @RequestBody DataSourceEntity dataSource) {
        return dataSourceRepository.save(dataSource);
    }


}