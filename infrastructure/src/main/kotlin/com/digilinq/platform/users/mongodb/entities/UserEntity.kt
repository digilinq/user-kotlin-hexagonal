package com.digilinq.platform.users.mongodb.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class UserEntity(
    @Id
    val id: String,
    val username: String,
    val password: String,
    val email: String
)
