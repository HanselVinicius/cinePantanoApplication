package com.pantano.cinePantanoApplication.core.application.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.GetMovieGateway
import com.pantano.cinePantanoApplication.core.domain.movie.dto.QueryMovieDto
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
        val queryMovieDto = QueryMovieDto(page,limit,null, null)
        // act
        getMoviesUseCase.getMovies(queryMovieDto)
        // assert
        verify(getMovieGateway).getMovies(queryMovieDto)
    }
}
