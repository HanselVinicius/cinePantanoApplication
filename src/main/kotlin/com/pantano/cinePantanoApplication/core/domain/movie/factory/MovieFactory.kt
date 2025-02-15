package com.pantano.cinePantanoApplication.core.domain.movie.factory

import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import java.time.LocalDate

class MovieFactory {
    fun createMovie(title: String, launchDate: LocalDate, duration: Int): Movie {
        return Movie(
            title = title,
            launchDate = launchDate,
            duration = duration,
            id = null,
            review = null,
            image = null,
            enabled = true
        )
    }
}
