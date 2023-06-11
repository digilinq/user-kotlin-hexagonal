package com.digilinq.platform.users.domain.user.service

import com.digilinq.platform.users.domain.user.model.User
import com.digilinq.platform.users.domain.user.ports.api.UserService
import com.digilinq.platform.users.domain.user.ports.spi.UserRepositoryPort

class UserServiceImpl(
    private val repository: UserRepositoryPort
) : UserService {
    override fun findById(userId: String): User {
        return repository.findById(userId)
    }

    override fun findByEmail(email: String): User {
        return repository.findByEmail(email)
    }

    override fun findAllUsers(page: Int, size: Int): List<User> {
        return repository.findAll(page, size)
    }
}