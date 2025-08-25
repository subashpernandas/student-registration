package com.tech.subash.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Bean
    public DataSource dataSource() {
        // For example, an H2 in-memory database
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&useLegacyDatetimeCode=false")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .username("root")
                .password("root")
                .build();
    }
}