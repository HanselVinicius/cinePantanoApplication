package com.pantano.cinePantanoApplication.core.domain.message.service

import com.pantano.cinePantanoApplication.core.domain.message.Message

interface MessageProcessor {
    fun processMessage(message: Message)
}
