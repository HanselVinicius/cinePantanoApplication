package com.pantano.cinePantanoApplication.configuration

import com.pantano.cinePantanoApplication.core.application.InsertMovieUseCase
import com.pantano.cinePantanoApplication.core.application.gateway.InsertMovieGateway
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
