package com.digilinq.platform.users.web.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.config.web.servlet.invoke
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity(debug = true)
class WebSecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            csrf {
                disable()
            }
            authorizeRequests {

                authorize("/greetings/**", hasAuthority("ROLE_ADMIN"))
                authorize("/**", permitAll)
            }
            httpBasic {}
        }
        return http.build()
    }

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { web: WebSecurity ->
            web.ignoring()
                .antMatchers(*SWAGGER_UI_V2)
                .antMatchers(*Swagger_UI_v3_OpenAPI)
                .antMatchers(*H2_CONSOLE)
        }
    }

    companion object {
        val H2_CONSOLE = arrayOf(
            "/h2-console/**"
        )

        val SWAGGER_UI_V2 = arrayOf(
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
        )

        val Swagger_UI_v3_OpenAPI = arrayOf(
            "/v3/api-docs/**",
            "/swagger-ui/**"
        )
    }
}
