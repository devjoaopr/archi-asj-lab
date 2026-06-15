package com.service.register.service;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Service
public class TenantMigrationService {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(TenantMigrationService.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void runLiquibase() {
        logger.info("Starting Liquibase migration");
        List<String> schemas = jdbcTemplate.queryForList(
                """
                        SELECT schema_name
                        FROM information_schema.schemata
                        WHERE schema_name NOT IN ('public', 'information_schema', 'pg_catalog', 'pg_toast')
                        AND schema_name NOT LIKE 'pg_%'
                        """,
                String.class
        );
        if (schemas.isEmpty()) {
            logger.info("No schemas were found.");
            return;
        }
        logger.info("Starting Liquibase migration");

        List<String> failed = new ArrayList<>();

        for (String schema : schemas) {
            try {
                logger.info("Starting Liquibase schema: " + schema);
                try (Connection connection = dataSource.getConnection()) {
                    try (Statement stmt = connection.createStatement()) {
                        stmt.execute("SET search_path TO " + schema);
                    }
                    Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));

                    database.setDefaultSchemaName(schema);
                    database.setLiquibaseSchemaName(schema);

                    Liquibase liquibase = new Liquibase(
                            "db.changelog/db.changelog-master.xml",
                            new ClassLoaderResourceAccessor(),
                            database
                    );
                    liquibase.update(new Contexts(), new LabelExpression());

                    logger.info("Liquibase migration complete");
                }
            } catch (SQLException e) {
                logger.info("Liquibase migration failed: " + e.getMessage());
                failed.add(schema);
            } catch (LiquibaseException e) {
                logger.info("Liquibase migration failed: " + e.getMessage());
                failed.add(schema);
            }
        }
        if (!failed.isEmpty()) {
            throw new RuntimeException("Migrations failed for the following schemas: " + failed);
        }
        logger.info("Liquibase migration complete");
    }
}
