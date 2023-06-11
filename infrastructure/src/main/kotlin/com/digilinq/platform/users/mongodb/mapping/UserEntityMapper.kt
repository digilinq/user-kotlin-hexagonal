package com.digilinq.platform.users.mongodb.mapping

import com.digilinq.platform.users.domain.user.model.User
import com.digilinq.platform.users.mongodb.entities.UserEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserEntityMapper {
    fun map(entity: UserEntity): User
}