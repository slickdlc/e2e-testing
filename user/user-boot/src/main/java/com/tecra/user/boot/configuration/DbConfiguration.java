package com.tecra.user.boot.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.tecra.user.infrastructure.repository",
    includeFilters = @ComponentScan.Filter(
        type = FilterType.REGEX,
        pattern = ".*JpaRepository"))
@EntityScan("com.tecra.user.infrastructure.entity")
public class DbConfiguration {

}
