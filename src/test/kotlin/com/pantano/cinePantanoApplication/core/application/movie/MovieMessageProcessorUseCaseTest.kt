package com.pantano.cinePantanoApplication.core.application.movie

import com.pantano.cinePantanoApplication.core.domain.message.Message
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.MovieStatus
import com.pantano.cinePantanoApplication.core.domain.movie.service.InsertMovieService
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import java.time.LocalDate
import kotlin.test.Test

class MovieMessageProcessorUseCaseTest {
    @Test
    fun shouldProcessMessageAndInsertMovie() {
        val messageMock = mock(Message::class.java)
        val movie = Movie(
            title = "title",
            movieStatus = MovieStatus.TO_WATCH,
            launchDate = LocalDate.now(),
            image = "",
            id = 1,
            review = emptySet(),
            duration = 10,
            enabled = true
        )
        val insertMovieService = mock(InsertMovieService::class.java)
        val movieMessageProcessorUseCase = MovieMessageProcessorUseCase(insertMovieService)

        `when`(messageMock.createMovieFromMessage()).thenReturn(movie)
        movieMessageProcessorUseCase.processMessage(messageMock)

        verify(insertMovieService).insertMovie(movie)
    }
}
