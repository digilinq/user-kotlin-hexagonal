package com.digilinq.platform.users.configuration

import com.digilinq.platform.users.domain.user.ports.api.UserService
import com.digilinq.platform.users.domain.user.ports.spi.UserRepositoryPort
import com.digilinq.platform.users.domain.user.service.UserServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration {

    @Bean
    fun userService(repository: UserRepositoryPort): UserService =
        UserServiceImpl(repository)
}