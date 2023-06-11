package com.digilinq.platform.users.mongodb.repositories

import com.digilinq.platform.users.mongodb.entities.UserEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserMongoRepository : MongoRepository<UserEntity, String> {
}