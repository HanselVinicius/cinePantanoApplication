package com.pantano.cinePantanoApplication.core.application.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.WatchMovieGateway
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.service.WatchMovieService

class WatchMovieUseCase(private val watchMovieGateway: WatchMovieGateway) : WatchMovieService {
    override fun watchMovie(movie: Movie): Movie {
        movie.watchMovie()
        return watchMovieGateway.watchMovie(movie)
    }
}
