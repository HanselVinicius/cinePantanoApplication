package com.pantano.cinePantanoApplication.gateway.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.GetMovieGateway
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntityRepository
import com.pantano.cinePantanoApplication.gateway.movie.mapper.MovieEntityMapper
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class GetMovieGatewayImpl(private val movieEntityRepository: MovieEntityRepository) : GetMovieGateway {
    override fun getMovies(page: Int, limit: Int?): List<Movie> {
        val movieEntity = movieEntityRepository.findAll(PageRequest.of(page, limit ?: 10))
        val movieList = movieEntity.map {
            MovieEntityMapper.toDomain(it)
        }
        return movieList.toList()
    }
}
