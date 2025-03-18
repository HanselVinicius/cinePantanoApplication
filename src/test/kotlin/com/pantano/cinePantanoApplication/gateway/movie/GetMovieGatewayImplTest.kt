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
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import kotlin.test.assertEquals

class GetMovieGatewayImplTest {

    @Test
    fun shouldCallFindAllAndReturnAnListOfMovies() {
        // arrange
        val movie = Movie(
            movieStatus = MovieStatus.TO_WATCH,
            enabled = true,
            image = "image",
            id = null,
            title = "title",
            launchDate = null,
            duration = 120,
            review = null
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
            createdAt = null
        )
        val movieEntityRepository = mock(MovieEntityRepository::class.java)
        val getMovieGatewayImpl = GetMovieGatewayImpl(movieEntityRepository)
        val page = PageImpl(listOf(movieEntity))

        `when`(movieEntityRepository.findAll(PageRequest.of(0, 10))).thenReturn(page)
        // act
        val result = getMovieGatewayImpl.getMovies(page = 0, limit = 10)
        mockkObject(MovieEntityMapper)
        every { MovieEntityMapper.toDomain(movieEntity) } returns movie
        // assert
        verify(movieEntityRepository).findAll(PageRequest.of(0, 10))
        assertEquals(result[0].id, movie.id)
    }
}
