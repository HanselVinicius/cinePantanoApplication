package com.pantano.cinePantanoApplication.core.application.gateway

import com.pantano.cinePantanoApplication.core.domain.movie.Movie

interface InsertMovieGateway {
    fun insertMovie(movie: Movie)
}