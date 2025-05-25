package com.pantano.cinePantanoApplication.gateway.movie

import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.MovieStatus
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntity
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntityRepository
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieStatusEntity
import com.pantano.cinePantanoApplication.gateway.movie.mapper.MovieEntityMapper
import io.mockk.every
import io.mockk.mockkObject
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.times
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class InsertMovieGatewayImplTest {
    @Test
    fun shouldInsertMovie() {
        // arrange
        val movie = Movie(
            movieStatus = MovieStatus.TO_WATCH,
            enabled = true,
            image = "image",
            id = null,
            title = "title",
            launchDate = null,
            duration = 120,
            review = null,
            externalId = null
        )
        val movieEntity = MovieEntity(
            movieStatus = MovieStatusEntity.TO_WATCH,
            enabled = true,
            image = "image",
            id = null,
            title = "title",
            launchDate = null,
            duration = 120,
            review = null,
            updatedAt = null,
            createdAt = null,
            externalId = null
        )
        mockkObject(MovieEntityMapper)
        every { MovieEntityMapper.toEntity(movie) } returns movieEntity
        val insertMovieRepository = mock(MovieEntityRepository::class.java)
        val insertMovieGatewayImpl = InsertMovieGatewayImpl(insertMovieRepository)
        // act
        insertMovieGatewayImpl.insertMovie(movie)
        // assert
        verify(insertMovieRepository, times(1)).save(movieEntity)
    }
}
