package com.devsu.user.config;

import com.devsu.user.boot.UserApplication;
import com.devsu.user.boot.configuration.DbConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {UserApplication.class, DbConfiguration.class})
@ActiveProfiles({"test"})
@TestConfiguration
public abstract class ApplicationAbstractIT {

}