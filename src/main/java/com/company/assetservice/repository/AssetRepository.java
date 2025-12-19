package com.company.assetservice.repository;

import com.company.assetservice.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
