package com.company.assetservice.service;

import com.company.assetservice.model.Asset;
import com.company.assetservice.repository.AssetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    private final AssetRepository repository;

    public AssetService(AssetRepository repository) {
        this.repository = repository;
    }

    public Asset create(String name, String type) {
        return repository.save(new Asset(name, type, "AVAILABLE"));
    }

    public List<Asset> getAll() {
        return repository.findAll();
    }

    public Asset getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found"));
    }

    public Asset updateStatus(Long id, String status) {
        Asset asset = getById(id);
        asset.setStatus(status);
        return repository.save(asset);
    }
}
