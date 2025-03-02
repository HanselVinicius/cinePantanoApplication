package com.pantano.cinePantanoApplication.configuration.security.auth

import com.pantano.cinePantanoApplication.core.application.auth.GetSubjectUseCase
import com.pantano.cinePantanoApplication.core.application.gateway.auth.GetSubjectGateway
import com.pantano.cinePantanoApplication.core.domain.auth.service.GetSubjectService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GetSubjectConfig {

    @Bean
    fun getSubjectService(getSubjectGateway: GetSubjectGateway): GetSubjectService {
        return GetSubjectUseCase(getSubjectGateway)
    }
}
