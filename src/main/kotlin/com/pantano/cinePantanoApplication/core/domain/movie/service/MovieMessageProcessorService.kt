package com.pantano.cinePantanoApplication.core.domain.movie.service

import com.pantano.cinePantanoApplication.core.domain.message.Message
import com.pantano.cinePantanoApplication.core.domain.message.service.MessageProcessor

interface MovieMessageProcessorService : MessageProcessor {
    override fun processMessage(message: Message)
}
