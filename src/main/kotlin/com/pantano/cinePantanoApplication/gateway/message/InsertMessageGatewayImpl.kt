package com.pantano.cinePantanoApplication.gateway.message

import com.pantano.cinePantanoApplication.core.application.gateway.message.InsertMessageGateway
import com.pantano.cinePantanoApplication.core.domain.message.Message
import com.pantano.cinePantanoApplication.gateway.message.entities.AttachmentRepository
import com.pantano.cinePantanoApplication.gateway.message.entities.MessageRepository
import com.pantano.cinePantanoApplication.gateway.message.mapper.MessageEntityMapper
import org.springframework.stereotype.Component

@Component
class InsertMessageGatewayImpl(
    private val messageRepository: MessageRepository,
    private val attachmentRepository: AttachmentRepository
) : InsertMessageGateway {
    override fun insertMessage(message: Message) {
        val messageEntity = MessageEntityMapper.toEntity(message)
        messageEntity.attachmentEntity.forEach(this.attachmentRepository::save)
        if (messageRepository.existsById(message.id)) {
            return
        }
        messageRepository.save(messageEntity)
    }
}
