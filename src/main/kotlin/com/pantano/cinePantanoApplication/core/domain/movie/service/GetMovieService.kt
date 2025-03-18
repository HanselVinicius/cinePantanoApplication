package com.pantano.cinePantanoApplication.core.domain.movie.service

import com.pantano.cinePantanoApplication.core.domain.movie.Movie

interface GetMovieService {
    fun getMovies(page: Int, limit: Int?): List<Movie>
}
