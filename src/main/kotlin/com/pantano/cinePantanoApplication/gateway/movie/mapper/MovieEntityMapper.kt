package com.pantano.cinePantanoApplication.gateway.movie.mapper

import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.gateway.movie.MovieEntity

object MovieEntityMapper {
    fun toEntity(movie: Movie): MovieEntity {
        return MovieEntity(
            id = movie.id,
            title = movie.title,
            duration = movie.duration,
            launchDate = movie.launchDate,
            review = movie.review?.map { review -> ReviewEntityMapper.toEntity(review) }.let {
                it?.toSet()
            },
            createdAt = null,
            updatedAt = null,
            enabled = movie.enabled
        )
    }

    fun toEntitySimplified(movie: Movie): MovieEntity {
        return MovieEntity(
            id = movie.id,
            title = movie.title,
            duration = movie.duration,
            launchDate = movie.launchDate,
            review = null,
            createdAt = null,
            updatedAt = null,
            enabled = movie.enabled
        )
    }
}
