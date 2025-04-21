package com.pantano.cinePantanoApplication.core.application.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.GetMovieGateway
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.dto.QueryMovieDto
import com.pantano.cinePantanoApplication.core.domain.movie.service.GetMovieService

class GetMoviesUseCase(private val getMovieGateway: GetMovieGateway) : GetMovieService {
    override fun getMovies(queryMovieDto: QueryMovieDto): List<Movie> {
        return getMovieGateway.getMovies(queryMovieDto)
    }
}
