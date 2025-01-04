package com.pantano.cinePantanoApplication.gateway.author

import com.pantano.cinePantanoApplication.core.domain.author.Author
import com.pantano.cinePantanoApplication.gateway.movie.mapper.ReviewEntityMapper

object AuthorEntityMapper {
    fun toEntity(author: Author): AuthorEntity {
        return AuthorEntity(
            id = author.id,
            name = author.name,
            createdAt = null,
            updatedAt = null,
            review = author.review.map { review -> ReviewEntityMapper.toEntitySimplified(review) }.toSet(),
            enabled = author.enabled
        )
    }
}
