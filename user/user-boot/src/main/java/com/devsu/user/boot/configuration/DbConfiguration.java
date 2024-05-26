package com.devsu.user.boot.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.devsu.user.infrastructure.repository",
    includeFilters = @ComponentScan.Filter(
        type = FilterType.REGEX,
        pattern = ".*JpaRepository"))
@EntityScan("com.devsu.user.infrastructure.entity")
public class DbConfiguration {

}
