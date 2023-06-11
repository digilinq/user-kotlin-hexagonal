package com.digilinq.platform.users.adapters

import com.digilinq.platform.users.domain.user.model.User
import com.digilinq.platform.users.domain.user.ports.spi.UserRepositoryPort
import com.digilinq.platform.users.mongodb.mapping.UserEntityMapper
import com.digilinq.platform.users.mongodb.repositories.UserMongoRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class UserRepositoryAdapter(
    private val repository: UserMongoRepository,
    private val mapper: UserEntityMapper
) : UserRepositoryPort {
    override fun findById(userId: String): User {
        TODO("Not yet implemented")
    }

    override fun findByEmail(email: String): User {
        TODO("Not yet implemented")
    }

    override fun findAll(page: Int, size: Int): List<User> {
        val page= PageRequest.of(page, size)
        return repository.findAll(page).map { mapper.map(it) }.toMutableList()
    }
}