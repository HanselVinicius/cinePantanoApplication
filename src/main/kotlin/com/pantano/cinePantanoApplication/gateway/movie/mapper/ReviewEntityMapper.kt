package com.pantano.cinePantanoApplication.gateway.movie.mapper

import com.pantano.cinePantanoApplication.core.domain.movie.Review
import com.pantano.cinePantanoApplication.gateway.author.mapper.AuthorEntityMapper
import com.pantano.cinePantanoApplication.gateway.movie.entities.ReviewEntity

object ReviewEntityMapper {

    fun toDomain(reviewEntity: ReviewEntity): Review {
        return Review(
            id = reviewEntity.id,
            author = AuthorEntityMapper.toDomain(reviewEntity.author),
            review = reviewEntity.review,
            rating = reviewEntity.rating,
            movie = if (reviewEntity.movie != null) MovieEntityMapper.toDomain(reviewEntity.movie!!) else null,
            enabled = reviewEntity.enabled
        )
    }

    fun toEntity(review: Review): ReviewEntity {
        return ReviewEntity(
            id = review.id,
            author = AuthorEntityMapper.toEntity(review.author),
            review = review.review,
            rating = review.rating,
            createdAt = null,
            updatedAt = null,
            movie = review.movie?.let { MovieEntityMapper.toEntitySimplified(it) },
            enabled = review.enabled
        )
    }

    fun toEntitySimplified(review: Review?): ReviewEntity? {
        if (review == null) {
            return null
        }
        return ReviewEntity(
            id = review.id,
            author = AuthorEntityMapper.toEntity(review.author),
            review = review.review,
            rating = review.rating,
            createdAt = null,
            updatedAt = null,
            movie = null,
            enabled = review.enabled
        )
    }
}
