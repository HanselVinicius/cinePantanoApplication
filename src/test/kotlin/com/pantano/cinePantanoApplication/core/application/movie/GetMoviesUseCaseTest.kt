package com.pantano.cinePantanoApplication.core.application.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.GetMovieGateway
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.MovieStatus
import com.pantano.cinePantanoApplication.core.domain.movie.dto.QueryMovieDto
import org.junit.jupiter.api.BeforeAll
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import java.time.LocalDate
import java.util.UUID
import kotlin.test.Test

class GetMoviesUseCaseTest {

    companion object {
        lateinit var getMovieGateway: GetMovieGateway
        lateinit var movie: Movie

        @BeforeAll
        @JvmStatic
        fun setUp() {
            getMovieGateway = mock(GetMovieGateway::class.java)
            movie = Movie(
                id = 1,
                title = "Movie",
                launchDate = LocalDate.now(),
                duration = 120,
                review = null,
                image = null,
                enabled = true,
                externalId = UUID.randomUUID().toString()
            )
        }
    }

    @Test
    fun shouldCallGetMoviesGateway() {
        // arrange
        val getMoviesUseCase = GetMoviesUseCase(getMovieGateway)
        val page = 1
        val limit = 10
        val queryMovieDto = QueryMovieDto(page, limit, null, null)
        `when`(getMovieGateway.getMovies(queryMovieDto)).thenReturn(
            listOf(
                movie
            )
        )
        // act
        val result = getMoviesUseCase.getMovies(queryMovieDto)
        // assert
        verify(getMovieGateway).getMovies(queryMovieDto)
        assert(result.isNotEmpty())
        assert(result[0].id == movie.id)
        assert(result[0].title == movie.title)
        assert(result[0].duration == movie.duration)
        assert(result[0].launchDate == movie.launchDate)
        assert(result[0].enabled == movie.enabled)
        assert(result[0].movieStatus == MovieStatus.TO_WATCH)
    }

    @Test
    fun shouldCallGetMoviesByIdGateway() {
        // arrange
        val getMovieGateway = mock(GetMovieGateway::class.java)
        val getMoviesUseCase = GetMoviesUseCase(getMovieGateway)
        val id = "1L"
        `when`(
            getMovieGateway.getMovieByExternalId(id)
        ).thenReturn(
            movie
        )
        // act
        val result = getMoviesUseCase.getMovieByExternalId(id)
        // assert
        verify(getMovieGateway).getMovieByExternalId(id)
        assert(result.id == movie.id)
        assert(result.title == movie.title)
        assert(result.duration == movie.duration)
        assert(result.launchDate == movie.launchDate)
        assert(result.enabled == movie.enabled)
        assert(result.movieStatus == MovieStatus.TO_WATCH)
    }
}
