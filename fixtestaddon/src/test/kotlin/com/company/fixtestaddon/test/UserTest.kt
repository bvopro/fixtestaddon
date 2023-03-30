package com.company.fixtestaddon.test

import com.company.fixtestaddon.entity.User
import io.jmix.core.DataManager
import io.jmix.core.security.SystemAuthenticator
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
internal class UserTest {
    @Autowired
    var dataManager: DataManager? = null

    @Autowired
    var systemAuthenticator: SystemAuthenticator? = null
    @BeforeEach
    fun setUp() {
        systemAuthenticator!!.begin()
    }

    @AfterEach
    fun tearDown() {
        systemAuthenticator!!.end()
    }

    @Test
    fun contextLoads() {
    }

    @Test
    fun testAdminUser() {
        val admin =
            dataManager!!.load(User::class.java).id(UUID.fromString("60885987-1b61-4247-94c7-dff348347f93")).one()
        Assertions.assertEquals("admin", admin.getUsername())
    }
}
