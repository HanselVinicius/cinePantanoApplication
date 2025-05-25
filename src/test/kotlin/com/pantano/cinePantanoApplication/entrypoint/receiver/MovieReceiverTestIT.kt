package com.pantano.cinePantanoApplication.entrypoint.receiver

import com.pantano.cinePantanoApplication.IntegrationTest
import com.pantano.cinePantanoApplication.entrypoint.dto.MovieMessageDto
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntityRepository
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieStatusEntity
import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.AfterEach
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDateTime
import kotlin.test.Test

@IntegrationTest
class MovieReceiverTestIT {

    companion object {
        const val MOVIE_QUEUE = "movieQueue"
    }

    @Autowired
    lateinit var movieRepository: MovieEntityRepository

    @Autowired
    lateinit var rabbitTemplate: RabbitTemplate

    @AfterEach
    fun afterEach() {
        this.movieRepository.deleteAll()
    }

    @Test
    fun shouldReceiveAMovieAndInsertIt() {
        val movie = MovieMessageDto(title = "title", launchDate = LocalDateTime.now(), duration = 120)
        rabbitTemplate.convertAndSend(MOVIE_QUEUE, movie)

        Thread.sleep(1000)

        val movies = movieRepository.findAll()
        assertEquals(1, movies.size)
        assertEquals("title", movies.first().title)
        assertEquals(120, movies.first().duration)
        assertEquals(MovieStatusEntity.TO_WATCH, movies.first().movieStatus)
    }
}
