package com.company.assetservice.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String status;

    private Instant createdAt = Instant.now();

    public Asset() {}

    public Asset(String name, String type, String status) {
        this.name = name;
        this.type = type;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public String getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }

    public void setStatus(String status) { this.status = status; }
}
