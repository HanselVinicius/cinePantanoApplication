package com.pantano.cinePantanoApplication.configuration.message

import com.pantano.cinePantanoApplication.core.domain.message.factory.MessageProcessorFactory
import com.pantano.cinePantanoApplication.core.domain.movie.service.MovieMessageProcessorService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProcessMessageFactoryConfig {
    @Bean
    fun createMessageProcessor(movieMessageProcessorService: MovieMessageProcessorService): MessageProcessorFactory {
        return MessageProcessorFactory(movieMessageProcessorService)
    }
}
