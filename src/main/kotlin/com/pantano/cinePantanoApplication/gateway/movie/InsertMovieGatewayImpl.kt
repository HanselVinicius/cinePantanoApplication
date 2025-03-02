package com.pantano.cinePantanoApplication.gateway.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.InsertMovieGateway
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntityRepository
import com.pantano.cinePantanoApplication.gateway.movie.mapper.MovieEntityMapper
import org.springframework.stereotype.Component

@Component
class InsertMovieGatewayImpl(private val movieEntityRepository: MovieEntityRepository) : InsertMovieGateway {
    override fun insertMovie(movie: Movie) {
        this.movieEntityRepository.save(MovieEntityMapper.toEntity(movie))
    }
}
