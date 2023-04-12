package com.misterdiallo.backend.connector.services.Implementations;

import com.misterdiallo.backend.connector.entities.StorageEntity;
import com.misterdiallo.backend.connector.entities.repositories.StorageRepository;
import com.misterdiallo.backend.connector.services.StorageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StorageImplementationService implements StorageService {
    private final StorageRepository repository;
    @Override
    public List<StorageEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public StorageEntity findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public StorageEntity save(StorageEntity resource) {
        return repository.save(resource);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
