package com.pantano.cinePantanoApplication.gateway.message

import com.pantano.cinePantanoApplication.core.domain.author.Author
import com.pantano.cinePantanoApplication.core.domain.message.Attachment
import com.pantano.cinePantanoApplication.core.domain.message.Message
import com.pantano.cinePantanoApplication.core.domain.message.vo.MessageType
import com.pantano.cinePantanoApplication.gateway.author.entities.AuthorEntity
import com.pantano.cinePantanoApplication.gateway.message.entities.AttachmentEntity
import com.pantano.cinePantanoApplication.gateway.message.entities.AttachmentRepository
import com.pantano.cinePantanoApplication.gateway.message.entities.MessageEntity
import com.pantano.cinePantanoApplication.gateway.message.entities.MessageRepository
import com.pantano.cinePantanoApplication.gateway.message.mapper.MessageEntityMapper
import io.mockk.every
import io.mockk.mockkObject
import org.mockito.BDDMockito.never
import org.mockito.BDDMockito.times
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import java.time.LocalDate
import kotlin.test.Test

class InsertMessageGatewayImplTest {

    @Test
    fun shouldInsertMessage() {
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
        val authorEntity = AuthorEntity(
            id = 1,
            name = "author",
            review = emptySet(),
            isBot = false,
            enabled = false,
            createdAt = LocalDate.now(),
            updatedAt = null
        )
        val attachmentEntity = AttachmentEntity(
            id = 1,
            attachment = "attachment",
            name = "name",
            size = 1,
            url = "url",
            messageEntity = null,
            enabled = true,
            createdAt = LocalDate.now(),
            updatedAt = null
        )
        val messageEntity = MessageEntity(
            id = 1,
            content = "message",
            author = authorEntity,
            channelId = 1,
            guildId = 1,
            attachmentEntity = setOf(attachmentEntity),
            timestamp = LocalDate.now(),
            type = MessageType.MOVIE,
            enabled = true,
            createdAt = LocalDate.now(),
            updatedAt = null
        )
        mockkObject(MessageEntityMapper)
        every { MessageEntityMapper.toEntity(message) } returns messageEntity
        val messageRepository: MessageRepository = mock(MessageRepository::class.java)
        val attachmentRepository: AttachmentRepository = mock(AttachmentRepository::class.java)
        val insertMessageGateway = InsertMessageGatewayImpl(messageRepository, attachmentRepository)

        // act
        insertMessageGateway.insertMessage(message)

        // assert
        `when`(messageRepository.save(messageEntity)).thenReturn(messageEntity)
        `when`(attachmentRepository.save(attachmentEntity)).thenReturn(attachmentEntity)
        verify(messageRepository).save(messageEntity)
        verify(attachmentRepository).save(attachmentEntity)
    }

    @Test
    fun shouldNotInsertMessageIfAlreadyExists() {
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
        val authorEntity = AuthorEntity(
            id = 1,
            name = "author",
            review = emptySet(),
            isBot = false,
            enabled = false,
            createdAt = LocalDate.now(),
            updatedAt = null
        )
        val attachmentEntity = AttachmentEntity(
            id = 1,
            attachment = "attachment",
            name = "name",
            size = 1,
            url = "url",
            messageEntity = null,
            enabled = true,
            createdAt = LocalDate.now(),
            updatedAt = null
        )
        val messageEntity = MessageEntity(
            id = 1,
            content = "message",
            author = authorEntity,
            channelId = 1,
            guildId = 1,
            attachmentEntity = setOf(attachmentEntity),
            timestamp = LocalDate.now(),
            type = MessageType.MOVIE,
            enabled = true,
            createdAt = LocalDate.now(),
            updatedAt = null
        )
        val messageRepository: MessageRepository = mock(MessageRepository::class.java)
        val attachmentRepository: AttachmentRepository = mock(AttachmentRepository::class.java)
        val insertMessageGateway = InsertMessageGatewayImpl(messageRepository, attachmentRepository)

        // act
        insertMessageGateway.insertMessage(message)

        // assert
        `when`(messageRepository.existsById(messageEntity.id)).thenReturn(true)
        verify(messageRepository, never()).save(messageEntity)
    }
}
