package com.pantano.cinePantanoApplication.gateway.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.GetMovieGateway
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.dto.QueryMovieDto
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntityRepository
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieStatusEntity
import com.pantano.cinePantanoApplication.gateway.movie.mapper.MovieEntityMapper
import com.pantano.cinePantanoApplication.gateway.movie.specifications.MovieSpecification
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component

@Component
class GetMovieGatewayImpl(private val movieEntityRepository: MovieEntityRepository) : GetMovieGateway {
    override fun getMovies(queryMovieDto: QueryMovieDto): List<Movie> {

        val movieEntityStatus = queryMovieDto.movieStatus.let {
            if (it == null) MovieStatusEntity.TO_WATCH else MovieStatusEntity.valueOf(it.name)
        }

        val movieSpecification = MovieSpecification(
            movieEntityStatus = movieEntityStatus,
            titleName = queryMovieDto.titleLike
        )

        val movieEntity = movieEntityRepository.findAll(
            movieSpecification,
            PageRequest.of(queryMovieDto.page, queryMovieDto.limit ?: 10),
        )

        val movieList = movieEntity.map {
            MovieEntityMapper.toDomain(it)
        }
        return movieList.toList()
    }
}
