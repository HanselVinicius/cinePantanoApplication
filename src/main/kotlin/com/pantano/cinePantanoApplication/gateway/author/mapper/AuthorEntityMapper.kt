package com.pantano.cinePantanoApplication.gateway.author.mapper

import com.pantano.cinePantanoApplication.core.domain.author.Author
import com.pantano.cinePantanoApplication.gateway.author.entities.AuthorEntity
import com.pantano.cinePantanoApplication.gateway.movie.mapper.ReviewEntityMapper

object AuthorEntityMapper {

    fun toDomain(author: AuthorEntity): Author {
        return Author(
            id = author.id,
            name = author.name,
            review = author.review.map { review -> ReviewEntityMapper.toDomain(review!!) },
            enabled = author.enabled,
            isBot = author.isBot
        )
    }

    fun toEntity(author: Author): AuthorEntity {
        return AuthorEntity(
            id = author.id,
            name = author.name,
            createdAt = null,
            updatedAt = null,
            review = author.review.map { review -> ReviewEntityMapper.toEntitySimplified(review) }.toSet(),
            enabled = author.enabled,
            isBot = author.isBot
        )
    }
}
