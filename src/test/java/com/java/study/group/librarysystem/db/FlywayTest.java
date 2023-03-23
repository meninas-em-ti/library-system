package com.java.study.group.librarysystem.db;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FlywayTest {

  @Autowired
  private DataSource dataSource;

  @Test
  void testFlywayMigration() {
    // Initialize Flyway
    Flyway flyway = Flyway.configure()
        .dataSource(dataSource)
        .locations("classpath:db/migration")
        .load();

    // Run Flyway migrations
    flyway.migrate();

    // Verify that the migrations were successful
    assertThat(flyway.info().applied().length).isEqualTo(2);
  }
}
