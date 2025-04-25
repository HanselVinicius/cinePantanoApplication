package com.pantano.cinePantanoApplication.core.domain.movie

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class MovieTest {

    @Test
    fun shouldWatchAMovie() {
        val movie = Movie(
            id = 1,
            title = "Movie",
            launchDate = null,
            duration = 120,
            review = null,
            image = null,
            enabled = true
        )

        movie.watchMovie()

        assertEquals(MovieStatus.WATCHED, movie.movieStatus)
    }

    @Test
    fun shouldNotWatchAMovieWithNullId() {
        val movie = Movie(
            id = null,
            title = "Movie",
            launchDate = null,
            duration = 120,
            review = null,
            image = null,
            enabled = true
        )

        val exception = assertThrows(IllegalArgumentException::class.java) {
            movie.watchMovie()
        }

        assertEquals("Movie id cannot be null", exception.message)
    }

    @Test
    fun shouldNotWatchAnMovieAlreadyWatched() {
        val movie = Movie(
            id = 1,
            title = "Movie",
            launchDate = null,
            duration = 120,
            review = null,
            image = null,
            enabled = true,
            movieStatus = MovieStatus.WATCHED
        )

        val exception = assertThrows(IllegalStateException::class.java) {
            movie.watchMovie()
        }

        assertEquals("Movie is not in an valid state to be watched", exception.message)
    }
}
