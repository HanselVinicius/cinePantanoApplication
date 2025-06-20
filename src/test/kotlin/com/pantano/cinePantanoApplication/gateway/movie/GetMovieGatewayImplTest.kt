package com.pantano.cinePantanoApplication.gateway.movie

import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.MovieStatus
import com.pantano.cinePantanoApplication.core.domain.movie.dto.QueryMovieDto
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntity
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntityRepository
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieStatusEntity
import com.pantano.cinePantanoApplication.gateway.movie.mapper.MovieEntityMapper
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.slot
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.domain.Specification
import java.util.*
import kotlin.test.assertEquals

class GetMovieGatewayImplTest {

    private val uuid = UUID.randomUUID().toString()

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
            review = null,
            externalId = uuid
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
            externalId = uuid
        )
        val movieEntityRepository = mockk<MovieEntityRepository>()
        val getMovieGatewayImpl = GetMovieGatewayImpl(movieEntityRepository)
        val page = PageImpl(listOf(movieEntity))
        val queryMovieDto = QueryMovieDto(
            page = 0,
            limit = 10,
            titleLike = null,
            movieStatus = null
        )
        val pageRequestSlot = slot<PageRequest>()
        val specSlot = slot<Specification<MovieEntity>>()
        every {
            movieEntityRepository.findAll(capture(specSlot), capture(pageRequestSlot))
        } returns page
        // act
        val result = getMovieGatewayImpl.getMovies(queryMovieDto)
        mockkObject(MovieEntityMapper)
        every { MovieEntityMapper.toDomain(movieEntity) } returns movie
        // assert

        verify {
            movieEntityRepository.findAll(specSlot.captured, pageRequestSlot.captured)
        }
        assertEquals(result[0].id, movie.id)
        assertEquals(result[0].launchDate, movie.launchDate)
        assertEquals(result[0].duration, movie.duration)
        assertEquals(result[0].enabled, movie.enabled)
        assertEquals(result[0].image, movie.image)
        assertEquals(result[0].movieStatus, movie.movieStatus)
        assertEquals(result[0].review, movie.review)
        assertEquals(result[0].title, movie.title)
    }

    @Test
    fun shouldCallFindByIdAndReturnAMovie() {
        // arrange
        val movie = Movie(
            movieStatus = MovieStatus.TO_WATCH,
            enabled = true,
            image = "image",
            id = 1,
            title = "title",
            launchDate = null,
            duration = 120,
            review = null,
            externalId = uuid
        )
        val movieEntity = MovieEntity(
            movieStatus = MovieStatusEntity.TO_WATCH,
            enabled = true,
            image = "image",
            id = 1,
            title = "title",
            launchDate = null,
            duration = 120,
            review = null,
            updatedAt = null,
            createdAt = null,
            externalId = uuid
        )
        val movieEntityRepository = mockk<MovieEntityRepository>()
        val getMovieGatewayImpl = GetMovieGatewayImpl(movieEntityRepository)
        every {
            movieEntityRepository.findByExternalId(movie.externalId!!)
        } returns Optional.of(movieEntity)
        // act
        val result = getMovieGatewayImpl.getMovieByExternalId(movie.externalId!!)
        mockkObject(MovieEntityMapper)
        every { MovieEntityMapper.toDomain(movieEntity) } returns movie
        // assert

        verify {
            movieEntityRepository.findByExternalId(uuid)
        }
        assertEquals(result.id, movie.id)
        assertEquals(result.launchDate, movie.launchDate)
        assertEquals(result.duration, movie.duration)
        assertEquals(result.enabled, movie.enabled)
        assertEquals(result.image, movie.image)
        assertEquals(result.movieStatus, movie.movieStatus)
        assertEquals(result.review, movie.review)
        assertEquals(result.title, movie.title)
    }
}
