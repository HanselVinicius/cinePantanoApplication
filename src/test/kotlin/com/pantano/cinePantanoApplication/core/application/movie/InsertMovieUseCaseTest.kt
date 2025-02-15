package com.pantano.cinePantanoApplication.core.application.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.InsertMovieGateway
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import java.time.LocalDate

class InsertMovieUseCaseTest {

    @Test
    fun shouldCallInsertMovieGateway() {
        // arrange
        val insertMovieGateway = mock<InsertMovieGateway>()
        val insertMovieUseCase = InsertMovieUseCase(insertMovieGateway)
        val movie = Movie(0, "description", LocalDate.now(), 10, null, "", true)
        // act
        insertMovieUseCase.insertMovie(movie)
        // assert
        verify(insertMovieGateway).insertMovie(movie)
    }
}
