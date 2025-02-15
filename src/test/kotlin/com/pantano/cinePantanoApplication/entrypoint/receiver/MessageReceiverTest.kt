package com.pantano.cinePantanoApplication.entrypoint.receiver

import com.pantano.cinePantanoApplication.core.domain.author.Author
import com.pantano.cinePantanoApplication.core.domain.author.service.InsertAuthorService
import com.pantano.cinePantanoApplication.core.domain.message.Attachment
import com.pantano.cinePantanoApplication.core.domain.message.Message
import com.pantano.cinePantanoApplication.core.domain.message.service.InsertMessageService
import com.pantano.cinePantanoApplication.core.domain.message.service.ProcessMessageService
import com.pantano.cinePantanoApplication.core.domain.message.vo.MessageType
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import java.time.LocalDate

class MessageReceiverTest {
    @Test
    fun shouldInsertAuthorAndMessage() {
        // arrange
        val insertMessageService = mock(InsertMessageService::class.java)
        val insertAuthorService = mock(InsertAuthorService::class.java)
        val processMessageService = mock(ProcessMessageService::class.java)
        val messageReceiver = MessageReceiver(insertMessageService, insertAuthorService, processMessageService)
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
        messageReceiver.receiveMessage(message)
        // assert
        verify(insertAuthorService).insertAuthor(author)
        verify(insertMessageService).insertMessage(message)
        verify(processMessageService).processMessage(message)
    }
}
