package com.pantano.cinePantanoApplication.core.domain.message.service

import com.pantano.cinePantanoApplication.core.domain.message.Message

interface ProcessMessageService {
    fun processMessage(message: Message)
}
