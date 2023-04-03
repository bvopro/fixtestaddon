package com.company.fixtestaddon.repository

import com.company.fixtestaddon.entity.NewEntity
import io.jmix.core.repository.JmixDataRepository
import java.util.*

interface NewEntityRepository : JmixDataRepository<NewEntity, UUID> {
    fun findByCode(code: String?): NewEntity?
}
