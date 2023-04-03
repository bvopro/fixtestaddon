package com.company.fixtestaddon.service

import com.company.fixtestaddon.entity.NewEntity
import com.company.fixtestaddon.repository.NewEntityRepository
import io.jmix.core.DataManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class NewEntityService {

    @Autowired
    lateinit var newEntityRepository: NewEntityRepository

    @Autowired
    lateinit var dataManager: DataManager

    fun isCodeAvailable(code: String) = newEntityRepository.findByCode(code) == null

    @OptIn(ExperimentalStdlibApi::class)
    fun findByCodeCustom (code: String) = dataManager.load(NewEntity::class.java)
    .query("select c from ${NewEntity::class.simpleName} c where c.code = :code")
    .parameter("code", code)
    .optional().getOrNull()
}
