package com.pantano.cinePantanoApplication.core.application.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.WatchMovieGateway
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.MovieStatus
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WatchMovieUseCaseTest {

    @Test
    fun shouldCallWatchMovieGatewayAndReturnMovie() {
        // arrange
        val movie = Movie(
            movieStatus = MovieStatus.TO_WATCH,
            enabled = true,
            image = "image",
            id = 1,
            title = "title",
            launchDate = null,
            duration = 120,
            review = null
        )
        val watchMovieGateway = mockk<WatchMovieGateway>()
        val watchMovieUseCase = WatchMovieUseCase(watchMovieGateway)
        every { watchMovieGateway.watchMovie(movie) } returns movie

        // act
        val result = watchMovieUseCase.watchMovie(movie)

        // assert
        assertEquals(movie, result)
        assertEquals(MovieStatus.WATCHED, result.movieStatus)
        assertEquals(MovieStatus.WATCHED, movie.movieStatus)
        assertEquals(true, result.enabled)
        assertEquals("image", result.image)
        assertEquals(1, result.id)
    }
}
