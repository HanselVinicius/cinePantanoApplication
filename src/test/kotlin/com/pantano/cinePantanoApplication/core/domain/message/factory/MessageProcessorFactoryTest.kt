package com.pantano.cinePantanoApplication.core.domain.message.factory

import com.pantano.cinePantanoApplication.core.domain.author.Author
import com.pantano.cinePantanoApplication.core.domain.message.Attachment
import com.pantano.cinePantanoApplication.core.domain.message.Message
import com.pantano.cinePantanoApplication.core.domain.message.vo.MessageType
import com.pantano.cinePantanoApplication.core.domain.movie.service.MovieMessageProcessorService
import org.junit.jupiter.api.Assertions.assertTrue
import org.mockito.Mockito.mock
import java.time.LocalDate
import kotlin.test.Test

class MessageProcessorFactoryTest {
    @Test
    fun createMessageProcessorShouldReturnAMovieMessageProcessorServiceWhenMessageTypeIsMOVIE() {
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
        val movieMessageProcessorServiceMock = mock(MovieMessageProcessorService::class.java)
        val factory = MessageProcessorFactory(movieMessageProcessorServiceMock)
        val processor = factory.createMessageProcessor(message)
        assertTrue(processor is MovieMessageProcessorService)
    }
}
