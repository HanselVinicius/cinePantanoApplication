package com.pantano.cinePantanoApplication.core.domain.movie.factory

import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.MovieStatus
import java.time.LocalDate

class MovieFactory {
    fun createMovie(title: String, launchDate: LocalDate, duration: Int, image: String? = ""): Movie {
        return Movie(
            title = title,
            launchDate = launchDate,
            duration = duration,
            id = null,
            review = null,
            image = image,
            enabled = true,
            externalId = null,
            movieStatus = MovieStatus.TO_WATCH
        )
    }
}
