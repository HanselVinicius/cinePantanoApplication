package com.pantano.cinePantanoApplication.core.application.message

import com.pantano.cinePantanoApplication.core.application.gateway.message.InsertMessageGateway
import com.pantano.cinePantanoApplication.core.domain.author.Author
import com.pantano.cinePantanoApplication.core.domain.message.Attachment
import com.pantano.cinePantanoApplication.core.domain.message.Message
import com.pantano.cinePantanoApplication.core.domain.message.vo.MessageType
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import java.time.LocalDate
import kotlin.test.Test

class InsertMessageUseCaseTest {

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
        val insertMessageGateway = mock(InsertMessageGateway::class.java)
        val insertMessageUseCase = InsertMessageUseCase(insertMessageGateway)

        // act
        insertMessageUseCase.insertMessage(message)

        // assert
        verify(insertMessageGateway).insertMessage(message)
    }
}
