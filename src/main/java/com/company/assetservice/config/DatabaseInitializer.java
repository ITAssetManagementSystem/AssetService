package com.company.assetservice.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseInitializer {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/assets/init-db")
    public String initDb() {
        jdbcTemplate.execute("""
            CREATE TABLE IF NOT EXISTS assets (
              id SERIAL PRIMARY KEY,
              name VARCHAR(255) NOT NULL,
              type VARCHAR(100) NOT NULL,
              status VARCHAR(50) NOT NULL,
              created_at TIMESTAMP NOT NULL
            )
        """);
        return "Asset DB schema initialized";
    }
}
