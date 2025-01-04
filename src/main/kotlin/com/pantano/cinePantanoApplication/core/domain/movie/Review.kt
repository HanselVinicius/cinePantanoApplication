package com.pantano.cinePantanoApplication.core.domain.movie

import com.pantano.cinePantanoApplication.core.domain.author.Author

class Review(
    val id: Long,
    val movie: Movie,
    val review: String,
    val rating: Int,
    val author: Author,
    val enabled: Boolean
)
