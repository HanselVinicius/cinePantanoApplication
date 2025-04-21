package com.pantano.cinePantanoApplication.core.domain.movie.service

import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.dto.QueryMovieDto

interface GetMovieService {
    fun getMovies(queryMovieDto: QueryMovieDto): List<Movie>
}
