package com.pantano.cinePantanoApplication.core.domain.movie.factory

import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import java.time.LocalDate

object MovieFactory {
    fun createMovie(title: String, launchDate: LocalDate, duration: Int): Movie {
        return Movie(null, title, launchDate, duration, null, true)
    }
}
