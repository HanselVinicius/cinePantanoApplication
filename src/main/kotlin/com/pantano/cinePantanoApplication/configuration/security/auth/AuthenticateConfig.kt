package com.pantano.cinePantanoApplication.configuration.security.auth

import com.pantano.cinePantanoApplication.core.application.auth.AuthenticateUseCase
import com.pantano.cinePantanoApplication.core.application.gateway.auth.AuthManagerGateway
import com.pantano.cinePantanoApplication.core.domain.auth.service.AuthenticateService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AuthenticateConfig {

    @Bean
    fun authenticateService(authManagerGateway: AuthManagerGateway): AuthenticateService {
        return AuthenticateUseCase(authManagerGateway)
    }
}
