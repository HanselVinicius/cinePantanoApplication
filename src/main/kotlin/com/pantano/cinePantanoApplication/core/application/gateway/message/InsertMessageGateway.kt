package com.pantano.cinePantanoApplication.core.application.gateway.message

import com.pantano.cinePantanoApplication.core.domain.message.Message

interface InsertMessageGateway {
    fun insertMessage(message: Message)
}
