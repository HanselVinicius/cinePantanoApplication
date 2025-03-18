package com.pantano.cinePantanoApplication.core.application.gateway.movie

import com.pantano.cinePantanoApplication.core.domain.movie.Movie

interface GetMovieGateway {
    fun getMovies(page: Int, limit: Int?): List<Movie>
}
