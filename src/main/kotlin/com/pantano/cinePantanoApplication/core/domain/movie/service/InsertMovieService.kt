package com.pantano.cinePantanoApplication.core.domain.movie.service

import com.pantano.cinePantanoApplication.core.domain.movie.Movie

interface InsertMovieService {
    fun insertMovie(movie: Movie)
}
