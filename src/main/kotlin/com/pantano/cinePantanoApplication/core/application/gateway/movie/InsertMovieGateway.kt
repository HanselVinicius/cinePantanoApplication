package com.pantano.cinePantanoApplication.core.application.gateway.movie

import com.pantano.cinePantanoApplication.core.domain.movie.Movie

interface InsertMovieGateway {
    fun insertMovie(movie: Movie)
}
