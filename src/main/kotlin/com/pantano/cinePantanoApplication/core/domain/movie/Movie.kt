package com.pantano.cinePantanoApplication.core.domain.movie

import java.time.LocalDate

class Movie(
    val id: Long,
    val title: String,
    val launchDate: LocalDate,
    val duration: Int,
    val review: List<Review>?
)
