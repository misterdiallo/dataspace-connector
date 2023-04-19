package com.misterdiallo.backend.connector.controllers;

import com.misterdiallo.backend.connector.dto.CreateRequestDTODataSet;
import com.misterdiallo.backend.connector.dto.ResponseRequestDTODataSet;
import com.misterdiallo.backend.connector.entities.DataSetEntity;
import com.misterdiallo.backend.connector.entities.DataSourceEntity;
import com.misterdiallo.backend.connector.entities.repositories.DataSetRepository;
import com.misterdiallo.backend.connector.entities.repositories.DataSourceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v0/api/data-sets")
public class DataSetController {
    private final DataSetRepository dataSetRepository;
    private final DataSourceRepository dataSourceRepository;

    @GetMapping()
    public ResponseEntity<List<ResponseRequestDTODataSet>> getAllDataSets() {
        List<DataSetEntity> allDataSets = dataSetRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<ResponseRequestDTODataSet> listResponseDataSets = new ArrayList<>();
        for (int i = 0; i < allDataSets.size(); i++) {
            DataSetEntity dataSet = allDataSets.get(i);
            System.out.println(allDataSets.get(i).getDataSource());
            listResponseDataSets.add(
                    ResponseRequestDTODataSet
                            .builder()
                            .id(dataSet.getId())
                            .name(dataSet.getName())
                            .dataSource(dataSet.getDataSource())
                            .build()
            );
        }
        log.info(listResponseDataSets.toString());
        return ResponseEntity.ok(listResponseDataSets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseRequestDTODataSet> getDataSetById(@PathVariable(value = "id") Long dataSetId) {
        Optional<DataSetEntity> dataSet = dataSetRepository.findById(dataSetId);
        return dataSet.map(dataSetEntity -> ResponseEntity.ok().body(ResponseRequestDTODataSet
                .builder()
                .id(dataSetEntity.getId())
                .name(dataSetEntity.getName())
                .dataSource(dataSetEntity.getDataSource())
                .build())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<DataSetEntity> createDataSet(@Valid @RequestBody CreateRequestDTODataSet request) {
        Optional<DataSourceEntity> dataSource = dataSourceRepository.findById(Long.valueOf(request.getDataSourceId()));
        if (dataSource.isPresent()) {
            DataSetEntity newDataSet = new DataSetEntity();
            newDataSet.setDataSource(dataSource.get());
            newDataSet.setName(request.getName());
            return ResponseEntity.ok(dataSetRepository.save(newDataSet));
        }
        return ResponseEntity.notFound().build();
    }
}