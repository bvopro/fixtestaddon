package com.company.autoconfigure.fixtestaddon

import com.company.fixtestaddon.FixTestConfiguration
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.Import

@AutoConfiguration
@Import(FixTestConfiguration::class)
open class FixTestAutoConfiguration {

}

