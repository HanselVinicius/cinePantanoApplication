package com.pantano.cinePantanoApplication.gateway.message.mapper

import com.pantano.cinePantanoApplication.core.domain.message.Message
import com.pantano.cinePantanoApplication.core.domain.message.vo.MessageType
import com.pantano.cinePantanoApplication.gateway.author.mapper.AuthorEntityMapper
import com.pantano.cinePantanoApplication.gateway.message.entities.MessageEntity

object MessageEntityMapper {

    fun toEntity(message: Message): MessageEntity {
        return MessageEntity(
            id = message.id,
            content = message.content,
            channelId = message.channelId,
            guildId = message.guildId,
            author = AuthorEntityMapper.toEntity(message.author),
            timestamp = message.timestamp,
            attachmentEntity = message.attachment
                .mapNotNull { it?.let { AttachmentEntityMapper.toEntity(it) } }
                .toSet(),
            type = MessageType.valueOf(message.messageType.name),
            enabled = true,
            createdAt = message.timestamp,
            updatedAt = null
        )
    }
}
