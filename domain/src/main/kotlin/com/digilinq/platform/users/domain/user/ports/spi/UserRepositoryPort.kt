package com.digilinq.platform.users.domain.user.ports.spi

import com.digilinq.platform.users.domain.user.model.User

interface UserRepositoryPort {
    fun findById(userId: String): User
    fun findByEmail(email: String): User
    fun findAll(page:Int, size:Int): List<User>
}