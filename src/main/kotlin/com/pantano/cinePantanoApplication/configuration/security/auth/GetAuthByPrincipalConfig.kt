package com.pantano.cinePantanoApplication.configuration.security.auth

import com.pantano.cinePantanoApplication.core.application.auth.GetAuthByPrincipalUseCase
import com.pantano.cinePantanoApplication.core.application.gateway.auth.GetAuthByPrincipalGateway
import com.pantano.cinePantanoApplication.core.domain.auth.service.GetAuthByPrincipalService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GetAuthByPrincipalConfig {

    @Bean
    fun getAuthByPrincipalService(getAuthByPrincipalGateway: GetAuthByPrincipalGateway): GetAuthByPrincipalService {
        return GetAuthByPrincipalUseCase(getAuthByPrincipalGateway)
    }
}
