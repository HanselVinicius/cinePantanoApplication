package com.pantano.cinePantanoApplication.core.application.gateway.movie

import com.pantano.cinePantanoApplication.core.domain.movie.Movie

interface WatchMovieGateway {
    fun watchMovie(movie: Movie): Movie
}
