package com.company.assetservice.controller;

import com.company.assetservice.model.Asset;
import com.company.assetservice.service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/assets")
public class AssetController {

    private final AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    @PostMapping
    public Asset create(@RequestBody Map<String, String> body) {
        return service.create(body.get("name"), body.get("type"));
    }

    @GetMapping
    public List<Asset> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Asset get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}/status")
    public Asset updateStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {
        return service.updateStatus(id, body.get("status"));
    }
}
