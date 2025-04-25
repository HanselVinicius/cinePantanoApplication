package com.pantano.cinePantanoApplication.core.domain.movie.service

import com.pantano.cinePantanoApplication.core.domain.movie.Movie

interface WatchMovieService {
    fun watchMovie(movie: Movie): Movie
}
