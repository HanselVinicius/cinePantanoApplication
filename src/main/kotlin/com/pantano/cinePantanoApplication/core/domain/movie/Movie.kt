package com.pantano.cinePantanoApplication.core.domain.movie

import java.time.LocalDate

class Movie(
    val id: Long?,
    val title: String,
    val launchDate: LocalDate?,
    val duration: Int,
    val review: Set<Review>?,
    val image: String?,
    val enabled: Boolean,
    val movieStatus: MovieStatus = MovieStatus.TO_WATCH
) {
    override fun toString(): String {
        return "Movie(id=$id, title='$title', launchDate=$launchDate, duration=$duration, review=$review, image=$image, enabled=$enabled, movieStatus=$movieStatus)"
    }
}
