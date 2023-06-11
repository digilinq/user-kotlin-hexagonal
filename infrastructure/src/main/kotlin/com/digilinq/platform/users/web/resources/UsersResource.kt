package com.digilinq.platform.users.web.resources

import com.digilinq.platform.users.common.constants.Endpoints.BASE_URL
import com.digilinq.platform.users.domain.user.ports.api.UserService
import com.digilinq.platform.users.web.generated.v1.api.UsersApi
import com.digilinq.platform.users.web.generated.v1.model.UserWithRoles
import com.digilinq.platform.users.web.mapping.UserMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("\${api.base-path:$BASE_URL}")
@RestController
class UsersResource(
    private val userService: UserService,
    private val mapper: UserMapper
) : UsersApi {
    override fun findAllUsers(
        username: String?,
        email: String?,
        page: Int?,
        size: Int?
    ): ResponseEntity<List<UserWithRoles>> {
        return ResponseEntity.ok(
            userService.findAllUsers(page ?: DEFAULT_PAGE, size ?: DEFAULT_SIZE).map { mapper.map(it) }
        )
    }

    companion object {
        const val DEFAULT_PAGE = 1
        const val DEFAULT_SIZE = 20
    }
}