package com.company.fixtestaddon

import io.jmix.core.annotation.JmixModule
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType

import javax.sql.DataSource

@SpringBootConfiguration
@EnableAutoConfiguration
@Import(FixTestConfiguration::class)
@JmixModule(id = "com.company.fixtestaddon.test", dependsOn = [FixTestConfiguration::class])
class FixTestTestConfiguration {

    @Bean
    @Primary
    fun dataSource(): DataSource {
        return EmbeddedDatabaseBuilder()
            .generateUniqueName(true)
            .setType(EmbeddedDatabaseType.HSQL)
            .build();
    }
}
