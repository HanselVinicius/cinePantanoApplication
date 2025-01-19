package com.pantano.cinePantanoApplication.gateway.author.mapper

import com.pantano.cinePantanoApplication.core.domain.author.Author
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.Review
import org.junit.jupiter.api.Assertions.assertEquals
import java.time.LocalDate
import kotlin.test.Test

class AuthorEntityMapperTest {

    @Test
    fun `test toEntity should correctly map Author to AuthorEntity`() {
        // Arrange
        val review = Review(
            id = 1L,
            author = Author(
                id = 1L,
                name = "John Doe",
                enabled = true,
                isBot = false,
                review = emptyList()
            ),
            review = "Great movie",
            rating = 5,
            enabled = true,
            movie = Movie(
                title = "The Matrix",
                launchDate = LocalDate.of(1999, 3, 31),
                id = 1L,
                duration = 120,
                review = emptySet(),
                enabled = true
            )
        )

        val author = Author(
            id = 1L,
            name = "John Doe",
            enabled = true,
            isBot = false,
            review = listOf(review)
        )

        // Act
        val authorEntity = AuthorEntityMapper.toEntity(author)

        assertEquals(author.id, authorEntity.id)
        assertEquals(author.name, authorEntity.name)
        assertEquals(author.enabled, authorEntity.enabled)
        assertEquals(author.isBot, authorEntity.isBot)
        assertEquals(1, authorEntity.review.size)
        assertEquals(null, authorEntity.createdAt)
        assertEquals(null, authorEntity.updatedAt)
    }
}
