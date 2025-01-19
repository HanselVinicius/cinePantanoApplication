package com.pantano.cinePantanoApplication.core.application.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.InsertMovieGateway
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.service.InsertMovieService

class InsertMovieUseCase(private val insertMovieGateway: InsertMovieGateway) : InsertMovieService {
    override fun insertMovie(movie: Movie) {
        insertMovieGateway.insertMovie(movie)
    }
}
