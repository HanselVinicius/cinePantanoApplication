package com.pantano.cinePantanoApplication.core.domain.message.service

import com.pantano.cinePantanoApplication.core.domain.message.Message

interface InsertMessageService {
    fun insertMessage(message: Message)
}
