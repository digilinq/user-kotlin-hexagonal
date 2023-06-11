package com.digilinq.platform.users.domain.user.ports.api

import com.digilinq.platform.users.domain.user.model.User

interface UserService {
    fun findById(userId: String): User
    fun findByEmail(email: String): User
    fun findAllUsers(page:Int, size:Int): List<User>
}