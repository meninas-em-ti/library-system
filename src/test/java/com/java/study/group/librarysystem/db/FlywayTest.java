package com.java.study.group.librarysystem.db;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FlywayTest {

  @Autowired
  private DataSource dataSource;

  @Test
  void testFlywayMigration() throws IOException {
    //Setup expected number of files that will be executed by the Flyway
    final Path folder = Paths.get("src/main/resources/db/migration");
    final long expectedSize = Files.walk(folder)
        .filter(Files::isRegularFile)
        .count();

    // Initialize Flyway
    final Flyway flyway = Flyway.configure()
        .dataSource(dataSource)
        .locations("classpath:db/migration")
        .load();

    // Run Flyway migrations
    flyway.migrate();

    // Verify that the migrations were successful
    final Long filesCountExecutedByFlyway = Arrays.stream(flyway.info().applied()).count();
    assertThat(filesCountExecutedByFlyway).isEqualTo(expectedSize);
  }
}
