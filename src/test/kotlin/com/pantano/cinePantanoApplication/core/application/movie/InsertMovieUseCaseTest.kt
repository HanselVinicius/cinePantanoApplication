package com.pantano.cinePantanoApplication.core.application.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.InsertMovieGateway
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.factory.MovieFactory
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import java.time.LocalDate

class InsertMovieUseCaseTest {

    companion object {
        lateinit var movieFactory: MovieFactory
        lateinit var movie: Movie

        @BeforeAll
        @JvmStatic
        fun setUp() {
            movieFactory = MovieFactory()
            movie = movieFactory.createMovie(
                title = "Movie",
                launchDate = LocalDate.now(),
                duration = 120,
                image = null
            )
        }
    }

    @Test
    fun shouldCallInsertMovieGateway() {
        // arrange
        val insertMovieGateway = mock<InsertMovieGateway>()
        val insertMovieUseCase = InsertMovieUseCase(insertMovieGateway)
        // act
        insertMovieUseCase.insertMovie(movie)
        // assert
        verify(insertMovieGateway).insertMovie(movie)
    }
}
