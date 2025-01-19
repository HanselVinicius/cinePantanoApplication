package com.pantano.cinePantanoApplication.core.domain.author

import com.pantano.cinePantanoApplication.core.domain.movie.Review

class Author(
    val id: Long,
    val name: String,
    var enabled: Boolean,
    val isBot: Boolean,
    val review: List<Review?> = emptyList()

) {
    override fun toString(): String {
        return "Author(id=$id, name='$name', enabled=$enabled, isBot=$isBot, review=$review)"
    }
}
