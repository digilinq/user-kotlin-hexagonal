package com.digilinq.platform.users.domain.user.model

data class User(
    val id: String,
    val username: String,
    val encryptedPassword: String,
    val email: String,
)
