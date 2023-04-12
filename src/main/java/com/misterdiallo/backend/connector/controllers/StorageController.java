package com.misterdiallo.backend.connector.controllers;

import com.misterdiallo.backend.connector.entities.StorageEntity;
import com.misterdiallo.backend.connector.services.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v0/api/storage")
public class StorageController {
    private final Environment env;
    private final StorageService storageService;


    //
    @GetMapping
    public List<StorageEntity> getAllResources() {
        return storageService.findAll();
    }

    @GetMapping("/{id}")
    public StorageEntity getResourceById(@PathVariable Long id) {
        return storageService.findById(id);
    }

    @PostMapping
    public StorageEntity createResource(@RequestBody StorageEntity resource) {
        return storageService.save(resource);
    }

    @DeleteMapping("/{id}")
    public void deleteResourceById(@PathVariable Long id) {
        storageService.deleteById(id);
    }

}
