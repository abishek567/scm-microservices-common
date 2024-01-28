package com.scm.common.db;

import com.scm.common.properties.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DbConnectivity {

    private final ApplicationProperties applicationProperties;

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(applicationProperties.getDbDriverClass());
        dataSourceBuilder.url(applicationProperties.getDbUrl());
        dataSourceBuilder.username(applicationProperties.getDbUserName());
        dataSourceBuilder.password(applicationProperties.getDbPassword());
        return dataSourceBuilder.build();
    }
}
