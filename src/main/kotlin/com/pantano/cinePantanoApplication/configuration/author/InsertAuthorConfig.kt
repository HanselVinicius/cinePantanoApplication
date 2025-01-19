package com.pantano.cinePantanoApplication.configuration.author

import com.pantano.cinePantanoApplication.core.application.author.InsertAuthorUseCase
import com.pantano.cinePantanoApplication.core.application.gateway.author.InsertAuthorGateway
import com.pantano.cinePantanoApplication.core.domain.author.service.InsertAuthorService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertAuthorConfig {
    @Bean
    fun insertAuthor(insertAuthorGateway: InsertAuthorGateway): InsertAuthorService {
        return InsertAuthorUseCase(insertAuthorGateway)
    }
}
