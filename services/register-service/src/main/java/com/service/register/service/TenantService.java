package com.service.register.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenantService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createTenant(String tenantName) {
        // Validate tenant name: allow only alphanumeric characters and underscores.
        if (!tenantName.matches("^[a-zA-Z0-9_]+$")) {
            throw new IllegalArgumentException("Invalid tenant name.");
        }
        String sql = "CREATE SCHEMA IF NOT EXISTS " + tenantName;

        jdbcTemplate.execute(sql);
    }
}
