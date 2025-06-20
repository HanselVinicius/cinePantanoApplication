package com.pantano.cinePantanoApplication.entrypoint.http

import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.MovieStatus
import com.pantano.cinePantanoApplication.core.domain.movie.dto.QueryMovieDto
import com.pantano.cinePantanoApplication.core.domain.movie.service.GetMovieService
import com.pantano.cinePantanoApplication.core.domain.movie.service.WatchMovieService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/movie")
class MovieController(
    private val getMovieService: GetMovieService,
    private val watchMovieService: WatchMovieService
) {

    @GetMapping
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

    @PatchMapping("/{externalId}")
    fun watchMovie(
        @PathVariable(required = true) externalId: String
    ): ResponseEntity<Movie> {
        val movie = this.getMovieService.getMovieByExternalId(externalId)
        val watchedMovie = this.watchMovieService.watchMovie(movie)
        return ResponseEntity.ok(watchedMovie)
    }
}
