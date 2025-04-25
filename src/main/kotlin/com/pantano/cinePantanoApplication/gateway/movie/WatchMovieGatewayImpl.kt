package com.pantano.cinePantanoApplication.gateway.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.WatchMovieGateway
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntityRepository
import com.pantano.cinePantanoApplication.gateway.movie.mapper.MovieEntityMapper
import org.springframework.stereotype.Component

@Component
class WatchMovieGatewayImpl(private val movieEntityRepository: MovieEntityRepository) : WatchMovieGateway {
    override fun watchMovie(movie: Movie): Movie {
        val movieEntity = MovieEntityMapper.toEntity(movie)
        return MovieEntityMapper.toDomain(this.movieEntityRepository.save(movieEntity))
    }
}
