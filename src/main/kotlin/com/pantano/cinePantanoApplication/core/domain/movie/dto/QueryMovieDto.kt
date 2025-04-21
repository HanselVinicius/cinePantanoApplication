package com.pantano.cinePantanoApplication.core.domain.movie.dto

import com.pantano.cinePantanoApplication.core.domain.movie.MovieStatus

data class QueryMovieDto(
    val page: Int,
    val limit: Int? = 10,
    val titleLike: String?,
    val movieStatus: MovieStatus?,
)