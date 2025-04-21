package com.pantano.cinePantanoApplication.core.application.gateway.movie

import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.dto.QueryMovieDto

interface GetMovieGateway {
    fun getMovies(queryMovieDto: QueryMovieDto): List<Movie>
}
