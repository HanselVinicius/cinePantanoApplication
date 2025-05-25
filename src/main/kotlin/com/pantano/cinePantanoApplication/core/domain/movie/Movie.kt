package com.pantano.cinePantanoApplication.core.domain.movie

import java.time.LocalDate

class Movie(
    val id: Long?,
    val externalId: String? = null,
    val title: String,
    val launchDate: LocalDate?,
    val duration: Int,
    val review: Set<Review>?,
    val image: String?,
    val enabled: Boolean,
    var movieStatus: MovieStatus = MovieStatus.TO_WATCH
) {

    fun watchMovie() {
        if (id == null) {
            throw IllegalArgumentException("Movie id cannot be null")
        }
        if (movieStatus != MovieStatus.TO_WATCH) {
            throw IllegalStateException("Movie is not in an valid state to be watched")
        }

        this.movieStatus = MovieStatus.WATCHED
    }

    override fun toString(): String {
        return "Movie(id=$id, externalId=$externalId, title='$title', launchDate=$launchDate, duration=$duration, review=$review, image=$image, enabled=$enabled, movieStatus=$movieStatus)"
    }
}
