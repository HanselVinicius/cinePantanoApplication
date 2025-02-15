package com.pantano.cinePantanoApplication.gateway.movie.mapper

import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntity
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieStatusEntity

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
            enabled = movie.enabled,
            movieStatus = MovieStatusEntity.valueOf(movie.movieStatus.name),
            image = movie.image
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
            enabled = movie.enabled,
            movieStatus = MovieStatusEntity.valueOf(movie.movieStatus.name),
            image = movie.image
        )
    }
}
