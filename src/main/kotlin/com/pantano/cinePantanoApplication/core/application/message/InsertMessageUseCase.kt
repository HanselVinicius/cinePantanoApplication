package com.pantano.cinePantanoApplication.core.application.message

import com.pantano.cinePantanoApplication.core.application.gateway.message.InsertMessageGateway
import com.pantano.cinePantanoApplication.core.domain.message.Message
import com.pantano.cinePantanoApplication.core.domain.message.service.InsertMessageService

class InsertMessageUseCase(
    private val insertMessageGateway: InsertMessageGateway
) : InsertMessageService {
    override fun insertMessage(message: Message) {
        insertMessageGateway.insertMessage(message)
    }
}
