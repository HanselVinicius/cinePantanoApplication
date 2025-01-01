package com.pantano.cinePantanoApplication.core.domain.movie

import com.pantano.cinePantanoApplication.core.domain.author.Author

class Review(
    val id: Long,
    val movieId: Long,
    val review: String,
    val rating: Int,
    val author: Author
)
