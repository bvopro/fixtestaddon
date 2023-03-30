package com.company.fixtestaddon

import io.cucumber.java.Before
import io.cucumber.java.Scenario
import io.cucumber.spring.CucumberContextConfiguration
import io.jmix.core.security.SystemAuthenticator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@CucumberContextConfiguration
@SpringBootTest(classes = [FixTestTestConfiguration::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CucumberSpringConfiguration {

    @Autowired
    lateinit var systemAuthenticator: SystemAuthenticator

    @Before
    fun before(scenario: Scenario) {
        systemAuthenticator.begin("admin")
    }
}
