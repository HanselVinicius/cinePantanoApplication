package com.pantano.cinePantanoApplication.core.application.message

import com.pantano.cinePantanoApplication.core.domain.message.Message
import com.pantano.cinePantanoApplication.core.domain.message.factory.MessageProcessorFactory
import com.pantano.cinePantanoApplication.core.domain.message.service.ProcessMessageService

class ProcessMessageUseCase(private val messageProcessorFactory: MessageProcessorFactory) : ProcessMessageService {
    override fun processMessage(message: Message) {
        val messageProcessor = messageProcessorFactory.createMessageProcessor(message)
        messageProcessor.processMessage(message)
    }
}
