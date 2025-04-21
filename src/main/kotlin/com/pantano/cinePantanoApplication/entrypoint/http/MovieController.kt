package com.pantano.cinePantanoApplication.entrypoint.http

import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.MovieStatus
import com.pantano.cinePantanoApplication.core.domain.movie.dto.QueryMovieDto
import com.pantano.cinePantanoApplication.core.domain.movie.service.GetMovieService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/movie")
class MovieController(private val getMovieService: GetMovieService) {

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    fun getMovies(
        @RequestParam(required = true) page: Int,
        @RequestParam(required = false) limit: Int?,
        @RequestParam(required = false) nameLike: String?,
        @RequestParam(required = false) movieStatus: MovieStatus?
    ): List<Movie> {
        val queryMovieDto = QueryMovieDto(
            page = page,
            limit = limit,
            titleLike = nameLike,
            movieStatus = movieStatus
        )
        return getMovieService.getMovies(queryMovieDto)
    }
}
