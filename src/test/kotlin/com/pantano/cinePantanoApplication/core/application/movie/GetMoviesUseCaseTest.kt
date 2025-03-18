package com.pantano.cinePantanoApplication.core.application.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.GetMovieGateway
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import kotlin.test.Test

class GetMoviesUseCaseTest {

    @Test
    fun shouldCallGetMoviesGateway() {
        // arrange
        val getMovieGateway = mock(GetMovieGateway::class.java)
        val getMoviesUseCase = GetMoviesUseCase(getMovieGateway)
        val page = 1
        val limit = 10
        // act
        getMoviesUseCase.getMovies(page, limit)
        // assert
        verify(getMovieGateway).getMovies(page, limit)
    }
}
