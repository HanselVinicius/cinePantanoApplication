package com.pantano.cinePantanoApplication.configuration.message

import com.pantano.cinePantanoApplication.core.application.gateway.message.InsertMessageGateway
import com.pantano.cinePantanoApplication.core.application.message.InsertMessageUseCase
import com.pantano.cinePantanoApplication.core.domain.message.service.InsertMessageService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertMessageConfig {
    @Bean
    fun insertMessage(insertMessageGateway: InsertMessageGateway): InsertMessageService {
        return InsertMessageUseCase(insertMessageGateway)
    }
}
