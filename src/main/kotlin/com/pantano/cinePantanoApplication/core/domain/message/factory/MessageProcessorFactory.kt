package com.pantano.cinePantanoApplication.core.domain.message.factory

import com.pantano.cinePantanoApplication.core.domain.message.Message
import com.pantano.cinePantanoApplication.core.domain.message.service.MessageProcessor
import com.pantano.cinePantanoApplication.core.domain.movie.service.MovieMessageProcessorService

class MessageProcessorFactory(private val movieMessageProcessorService: MovieMessageProcessorService) {

    fun createMessageProcessor(message: Message): MessageProcessor {
        when (message.messageType.name) {
            "MOVIE" -> return movieMessageProcessorService
            else -> throw IllegalArgumentException("Invalid message type")
        }
    }
}
