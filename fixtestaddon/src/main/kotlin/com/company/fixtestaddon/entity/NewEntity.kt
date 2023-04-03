package com.company.fixtestaddon.entity

import io.jmix.core.entity.annotation.JmixGeneratedValue
import io.jmix.core.metamodel.annotation.JmixEntity
import java.util.*
import javax.persistence.*

@JmixEntity
@Table(name = "FIX_TEST_NEW_ENTITY")
@Entity(name = "FixTest_NewEntity")
open class NewEntity {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    var id: UUID? = null

    @Column(name = "CODE")
    var code: String? = null

    @Column(name = "VERSION", nullable = false)
    @Version
    var version: Int? = null
}
