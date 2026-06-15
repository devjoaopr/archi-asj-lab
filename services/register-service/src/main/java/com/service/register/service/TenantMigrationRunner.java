package com.service.register.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        name = "app.run-tenant-migrations",
        havingValue = "true"
)
@RequiredArgsConstructor
public class TenantMigrationRunner implements CommandLineRunner {

    private final TenantMigrationService migrationService;

    @Override
    public void run(String... args) {
        migrationService.runLiquibase();
        System.exit(0);
    }
}

