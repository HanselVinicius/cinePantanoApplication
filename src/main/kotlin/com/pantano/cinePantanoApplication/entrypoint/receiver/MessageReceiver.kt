package com.pantano.cinePantanoApplication.entrypoint.receiver

import com.pantano.cinePantanoApplication.core.domain.author.service.InsertAuthorService
import com.pantano.cinePantanoApplication.core.domain.message.Message
import com.pantano.cinePantanoApplication.core.domain.message.service.InsertMessageService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class MessageReceiver(val insertMessageService: InsertMessageService, val insertAuthorService: InsertAuthorService) {

    @RabbitListener(queues = ["messageQueue"])
    fun receiveMessage(message: Message) {
        this.insertAuthorService.insertAuthor(message.author)
        this.insertMessageService.insertMessage(message)
    }
}
