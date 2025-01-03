package com.pantano.cinePantanoApplication.gateway.movie

import com.pantano.cinePantanoApplication.core.application.gateway.InsertMovieGateway
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import org.springframework.stereotype.Component

@Component
class InsertMovieGatewayImpl : InsertMovieGateway {
    override fun insertMovie(movie: Movie) {
        println("Inserting movie: $movie")
    }

}