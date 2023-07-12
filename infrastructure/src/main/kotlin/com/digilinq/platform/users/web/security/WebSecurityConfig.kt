package com.digilinq.platform.users.web.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@Configuration
@EnableWebSecurity(debug = true)
class WebSecurityConfig {
}