package com.pantano.cinePantanoApplication.configuration.message

import com.pantano.cinePantanoApplication.core.application.message.ProcessMessageUseCase
import com.pantano.cinePantanoApplication.core.domain.message.factory.MessageProcessorFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProcessMessageConfig {

    @Bean
    fun processMessage(messageProcessorFactory: MessageProcessorFactory): ProcessMessageUseCase {
        return ProcessMessageUseCase(messageProcessorFactory)
    }
}
