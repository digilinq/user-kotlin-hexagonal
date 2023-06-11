package com.digilinq.platform.users.web.mapping

import com.digilinq.platform.users.domain.user.model.User
import com.digilinq.platform.users.web.generated.v1.model.UserWithRoles
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserMapper {
    fun map(user: User):UserWithRoles
}