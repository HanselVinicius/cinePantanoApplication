package com.pantano.cinePantanoApplication.core.domain.movie.factory

import org.hibernate.validator.internal.util.Contracts.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import java.time.LocalDate
import kotlin.test.Test

class MovieFactoryTest {
    @Test
    fun shouldCreateAnMovieObjectToAddMovieFlow() {
        val date = LocalDate.now()
        val movie = MovieFactory().createMovie("title", date, 120)
        assertNotNull(movie)
        assertEquals("title", movie.title)
        assertEquals(LocalDate.now(), movie.launchDate)
        assertEquals(120, movie.duration)
        assertNull(movie.id)
        assertEquals("title", movie.title)
        assertEquals(date, movie.launchDate)
        assertEquals(120, movie.duration)
    }
}
