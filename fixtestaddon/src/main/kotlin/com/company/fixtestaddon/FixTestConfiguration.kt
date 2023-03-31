package com.company.fixtestaddon

import io.jmix.appsettings.AppSettingsConfiguration
import io.jmix.appsettingsui.AppSettingsUiConfiguration
import io.jmix.core.annotation.JmixModule
import io.jmix.core.impl.scanning.AnnotationScanMetadataReaderFactory
import io.jmix.eclipselink.EclipselinkConfiguration
import io.jmix.security.SecurityConfiguration
import io.jmix.securitydata.SecurityDataConfiguration
import io.jmix.securityui.SecurityUiConfiguration
import io.jmix.ui.UiConfiguration
import io.jmix.ui.sys.ActionsConfiguration
import io.jmix.ui.sys.UiControllersConfiguration
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@ComponentScan
@ConfigurationPropertiesScan
@JmixModule(dependsOn = [EclipselinkConfiguration::class, UiConfiguration::class, SecurityConfiguration::class, SecurityUiConfiguration::class, SecurityDataConfiguration::class, AppSettingsConfiguration::class, AppSettingsUiConfiguration::class])
@PropertySource(name = "com.company.fixtestaddon", value = ["classpath:/com/company/fixtestaddon/module.properties"])
open class FixTestConfiguration {

    @Bean("FixTest_FixTestUiControllers")
    open fun screens(applicationContext: ApplicationContext,
                metadataReaderFactory: AnnotationScanMetadataReaderFactory
    ): UiControllersConfiguration {
        return UiControllersConfiguration(applicationContext, metadataReaderFactory).apply {
            basePackages = listOf("com.company.fixtestaddon")
        }
    }

    @Bean("FixTest_FixTestUiActions")
    open fun actions(applicationContext: ApplicationContext,
                     metadataReaderFactory: AnnotationScanMetadataReaderFactory
    ): ActionsConfiguration {
        return ActionsConfiguration(applicationContext, metadataReaderFactory).apply {
            basePackages = listOf("com.company.fixtestaddon")
        }
    }
}
