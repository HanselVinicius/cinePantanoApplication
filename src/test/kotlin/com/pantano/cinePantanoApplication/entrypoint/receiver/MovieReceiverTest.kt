package com.pantano.cinePantanoApplication.entrypoint.receiver

import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.MovieStatus
import com.pantano.cinePantanoApplication.core.domain.movie.factory.MovieFactory
import com.pantano.cinePantanoApplication.core.domain.movie.service.InsertMovieService
import com.pantano.cinePantanoApplication.entrypoint.dto.MovieMessageDto
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import java.time.LocalDate
import java.time.LocalDateTime

class MovieReceiverTest {
    @Test
    fun shouldReceiveAMovieAndInsertIt() {
        // Arrange
        val movie = MovieMessageDto("title", LocalDateTime.now(), 120)
        val insertMovieService = mock<InsertMovieService>()
        val movieFactory = mock<MovieFactory>()
        val movieReceiver = MovieReceiver(insertMovieService, movieFactory)

        val createdMovie = Movie(
            title = "title",
            launchDate = LocalDate.of(2024, 1, 1),
            duration = 120,
            id = null,
            enabled = true,
            movieStatus = MovieStatus.TO_WATCH,
            image = "",
            review = null
        )

        `when`(movieFactory.createMovie(movie.title, LocalDate.of(movie.launchDate.year, movie.launchDate.monthValue, movie.launchDate.dayOfMonth), movie.duration))
            .thenReturn(createdMovie)

        movieReceiver.receiveMovie(movie)

        verify(insertMovieService).insertMovie(createdMovie)
    }
}
