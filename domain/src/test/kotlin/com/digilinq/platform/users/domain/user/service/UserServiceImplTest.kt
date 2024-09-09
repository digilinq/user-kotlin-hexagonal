package com.digilinq.platform.users.domain.user.service

import com.digilinq.platform.users.domain.user.model.User
import com.digilinq.platform.users.domain.user.ports.spi.UserRepositoryPort
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
class UserServiceImplTest {

    @InjectMockKs
    private lateinit var userService: UserServiceImpl

    @MockK
    private lateinit var userRepositoryPort: UserRepositoryPort

    @Test
    fun `should call underlying service with correct parameters`() {
        val userId = UUID.randomUUID().toString()
        val user = User(userId, USERNAME, ENCRYPTED_PASSWORD, EMAIL)

        every { userRepositoryPort.findById(userId) } returns user

        userService.findById(userId)

        verify { userRepositoryPort.findById(userId) }
    }

    companion object {
        const val USERNAME = "Hossein"
        const val ENCRYPTED_PASSWORD = "P@ssw0rd"
        const val EMAIL = "hossein.mohammadi@digilinq.org"
    }
}
