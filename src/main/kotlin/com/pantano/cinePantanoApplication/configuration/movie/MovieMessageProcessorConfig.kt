package com.pantano.cinePantanoApplication.configuration.movie

import com.pantano.cinePantanoApplication.core.application.movie.MovieMessageProcessorUseCase
import com.pantano.cinePantanoApplication.core.domain.movie.service.InsertMovieService
import com.pantano.cinePantanoApplication.core.domain.movie.service.MovieMessageProcessorService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MovieMessageProcessorConfig {

    @Bean
    fun movieMessageProcessor(insertMovieService: InsertMovieService): MovieMessageProcessorService {
        return MovieMessageProcessorUseCase(insertMovieService)
    }
}
