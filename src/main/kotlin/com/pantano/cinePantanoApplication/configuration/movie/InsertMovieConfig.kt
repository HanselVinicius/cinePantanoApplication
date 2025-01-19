package com.pantano.cinePantanoApplication.configuration.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.InsertMovieGateway
import com.pantano.cinePantanoApplication.core.application.movie.InsertMovieUseCase
import com.pantano.cinePantanoApplication.core.domain.movie.service.InsertMovieService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertMovieConfig {
    @Bean
    fun insertMovie(insertMovieGateway: InsertMovieGateway): InsertMovieService {
        return InsertMovieUseCase(insertMovieGateway)
    }
}
