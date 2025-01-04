package com.pantano.cinePantanoApplication.gateway.movie

import com.pantano.cinePantanoApplication.core.application.gateway.InsertMovieGateway
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.gateway.movie.mapper.MovieEntityMapper
import org.springframework.stereotype.Component

@Component
class InsertMovieGatewayImpl(private val movieRepository: MovieRepository) : InsertMovieGateway {
    override fun insertMovie(movie: Movie) {
        this.movieRepository.save(MovieEntityMapper.toEntity(movie))
    }
}
