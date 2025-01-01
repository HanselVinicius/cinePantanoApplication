package com.pantano.cinePantanoApplication.core.domain.author

import com.pantano.cinePantanoApplication.core.domain.movie.Review

class Author(
    val id: Long,
    val name: String,
    val review: List<Review>
)
