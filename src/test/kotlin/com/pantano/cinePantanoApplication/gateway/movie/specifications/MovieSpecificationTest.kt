package com.pantano.cinePantanoApplication.gateway.movie.specifications

import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntity
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieStatusEntity
import io.mockk.every
import io.mockk.mockk
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Path
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class MovieSpecificationTest {

    @Test
    fun shouldReturnCombinedPredicates_whenTitleAndStatusProvided() {
        // Arrange
        val movieSpecification = MovieSpecification(
            titleName = "title",
            movieEntityStatus = MovieStatusEntity.TO_WATCH
        )

        val rootMock = mockk<Root<MovieEntity>>()
        val queryMock = mockk<CriteriaQuery<*>>()
        val criteriaBuilderMock = mockk<CriteriaBuilder>()
        val titlePathMock = mockk<Path<String>>()
        val statusPathMock = mockk<Path<MovieStatusEntity>>()
        val likePredicateMock = mockk<Predicate>()
        val equalPredicateMock = mockk<Predicate>()
        val combinedPredicateMock = mockk<Predicate>()

        every { rootMock.get<String>("title") } returns titlePathMock
        every { rootMock.get<MovieStatusEntity>("movieStatus") } returns statusPathMock

        every { criteriaBuilderMock.like(titlePathMock, "%title%") } returns likePredicateMock
        every { criteriaBuilderMock.equal(statusPathMock, MovieStatusEntity.TO_WATCH) } returns equalPredicateMock

        every { criteriaBuilderMock.and(likePredicateMock, equalPredicateMock) } returns combinedPredicateMock

        // Act
        val result = movieSpecification.toPredicate(rootMock, queryMock, criteriaBuilderMock)

        // Assert
        assertNotNull(result)
        assertEquals(combinedPredicateMock, result)
    }
}
