package com.pantano.cinePantanoApplication.gateway.message.mapper

import com.pantano.cinePantanoApplication.core.domain.author.Author
import com.pantano.cinePantanoApplication.core.domain.message.Attachment
import com.pantano.cinePantanoApplication.core.domain.message.Message
import com.pantano.cinePantanoApplication.core.domain.message.vo.MessageType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.LocalDate

class MessageEntityMapperTest {

    @Test
    fun shouldMapDomainToEntity() {
        // arrange
        val author = Author(id = 1, name = "author", review = emptyList(), isBot = false, enabled = false)
        val attachment = Attachment(id = 1, attachment = "attachment", name = "name", size = 1, url = "url")
        val message = Message(
            id = 1,
            content = "message",
            author = author,
            channelId = 1,
            guildId = 1,
            attachment = setOf(attachment),
            timestamp = LocalDate.now(),
            messageType = MessageType.MOVIE
        )
        // act
        val messageEntity = MessageEntityMapper.toEntity(message)
        // assert
        assertEquals(message.id, messageEntity.id)
        assertEquals(message.content, messageEntity.content)
        assertEquals(message.channelId, messageEntity.channelId)
        assertEquals(message.guildId, messageEntity.guildId)
        assertEquals(message.timestamp, messageEntity.timestamp)
        assertEquals(message.messageType, MessageType.valueOf(messageEntity.type.name))
        assertEquals(message.attachment.size, messageEntity.attachmentEntity.size)
        assertEquals(message.author.id, messageEntity.author.id)
        assertEquals(message.author.name, messageEntity.author.name)
        assertEquals(message.author.isBot, messageEntity.author.isBot)
        assertEquals(message.author.enabled, messageEntity.author.enabled)
        assertEquals(LocalDate.now(), messageEntity.createdAt)
        assertEquals(null, messageEntity.updatedAt)
        assertTrue(messageEntity.enabled)
    }
}
