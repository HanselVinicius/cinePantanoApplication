package com.pantano.cinePantanoApplication.gateway.movie

import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.MovieStatus
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntity
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntityRepository
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieStatusEntity
import com.pantano.cinePantanoApplication.gateway.movie.mapper.MovieEntityMapper
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.UUID

class WatchMovieGatewayImplTest {

    private val uuid = UUID.randomUUID().toString()

    @Test
    fun shouldCallWatchMovieGatewayAndReturnMovie() {
        // arrange
        val movie = Movie(
            id = 1,
            title = "Test Movie",
            launchDate = LocalDate.now(),
            duration = 120,
            review = null,
            image = null,
            enabled = true,
            movieStatus = MovieStatus.WATCHED,
            externalId = uuid
        )

        val movieEntity = MovieEntity(
            enabled = true,
            id = 1,
            title = "Test",
            launchDate = LocalDate.of(2025, 3, 17),
            duration = 120,
            movieStatus = MovieStatusEntity.WATCHED,
            image = "image",
            createdAt = LocalDate.now(),
            updatedAt = LocalDate.now(),
            review = null,
            externalId = uuid
        )
        val movieEntityRepository = mockk<MovieEntityRepository>()
        val watchMovieGateway = WatchMovieGatewayImpl(movieEntityRepository)
        every { movieEntityRepository.save(movieEntity) } returns movieEntity

        mockkObject(MovieEntityMapper)
        every { MovieEntityMapper.toEntity(movie) } returns movieEntity
        every { MovieEntityMapper.toDomain(movieEntity) } returns movie
        // act
        val result = watchMovieGateway.watchMovie(movie)

        // assert
        verify {
            movieEntityRepository.save(movieEntity)
        }
        assertEquals(MovieStatus.WATCHED, result.movieStatus)
        assertEquals(movie, result)
    }
}
