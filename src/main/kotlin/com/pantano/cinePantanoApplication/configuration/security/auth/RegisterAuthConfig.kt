package com.pantano.cinePantanoApplication.configuration.security.auth

import com.pantano.cinePantanoApplication.core.application.auth.RegisterAuthUseCase
import com.pantano.cinePantanoApplication.core.application.gateway.auth.RegisterAuthGateway
import com.pantano.cinePantanoApplication.core.domain.auth.service.RegisterAuthService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RegisterAuthConfig {

    @Bean
    fun registerAuthGateway(authRegisterAuthGateway: RegisterAuthGateway): RegisterAuthService {
        return RegisterAuthUseCase(authRegisterAuthGateway)
    }
}
