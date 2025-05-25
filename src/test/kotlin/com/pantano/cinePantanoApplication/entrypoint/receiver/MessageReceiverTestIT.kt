package com.pantano.cinePantanoApplication.entrypoint.receiver

import com.pantano.cinePantanoApplication.IntegrationTest
import com.pantano.cinePantanoApplication.core.domain.author.Author
import com.pantano.cinePantanoApplication.core.domain.message.Attachment
import com.pantano.cinePantanoApplication.core.domain.message.Message
import com.pantano.cinePantanoApplication.core.domain.message.vo.MessageType
import com.pantano.cinePantanoApplication.gateway.author.entities.AuthorRepository
import com.pantano.cinePantanoApplication.gateway.message.entities.MessageRepository
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntityRepository
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieStatusEntity
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDate

@IntegrationTest
class MessageReceiverTestIT {

    companion object {
        const val MESSAGE_QUEUE = "messageQueue"
    }

    @Autowired
    lateinit var movieRepository: MovieEntityRepository

    @Autowired
    lateinit var authorRepository: AuthorRepository

    @Autowired
    lateinit var messageRepository: MessageRepository

    @Autowired
    lateinit var rabbitTemplate: RabbitTemplate

    lateinit var message: Message

    @BeforeEach
    fun beforeEach() {
        message = Message(
            id = 1L,
            author = Author(
                id = 1L,
                name = "fabiano",
                enabled = true,
                isBot = false,
                review = emptyList()
            ),
            content = "text",
            messageType = MessageType.MOVIE,
            channelId = 1L,
            guildId = 1L,
            timestamp = LocalDate.now(),
            attachment = setOf(
                Attachment(
                    id = 1L,
                    attachment = "attachment",
                    name = "name",
                    size = 1L,
                    url = "url"
                )
            )
        )
    }

    @AfterEach
    fun afterEach() {
        this.movieRepository.deleteAll()
    }

    @Test
    fun shouldReceiveAMessagesAndMakeInsertsIt() {
        rabbitTemplate.convertAndSend(MESSAGE_QUEUE, message)

        Thread.sleep(5000)

        val messages = messageRepository.findAll()
        val authors = authorRepository.findAll()
        val movies = movieRepository.findAll()

        assertEquals(1, messages.size)
        assertEquals(messages.first().id, message.id)
        assertEquals(messages.first().content, message.content)
        assertEquals(messages.first().channelId, message.channelId)
        assertEquals(messages.first().guildId, message.guildId)
        assertEquals(messages.first().timestamp, message.timestamp)

        assertEquals(1, authors.size)
        assertEquals(authors.first().id, message.author.id)
        assertEquals(authors.first().name, message.author.name)
        assertEquals(authors.first().enabled, message.author.enabled)
        assertEquals(authors.first().isBot, message.author.isBot)

        assertEquals(1, movies.size)
        assertEquals(movies.first().title, message.content)
        assertEquals(movies.first().image, message.attachment.first()?.url)
        assertEquals(movies.first().movieStatus.name, MovieStatusEntity.TO_WATCH.name)
        assertEquals(movies.first().duration, 0)
    }
}
