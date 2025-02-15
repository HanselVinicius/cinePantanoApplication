package com.pantano.cinePantanoApplication.core.application.movie

import com.pantano.cinePantanoApplication.core.domain.message.Message
import com.pantano.cinePantanoApplication.core.domain.movie.service.InsertMovieService
import com.pantano.cinePantanoApplication.core.domain.movie.service.MovieMessageProcessorService

class MovieMessageProcessorUseCase(private val insertMovieService: InsertMovieService) : MovieMessageProcessorService {
    override fun processMessage(message: Message) {
        val movie = message.createMovieFromMessage()
        insertMovieService.insertMovie(movie)
    }
}
