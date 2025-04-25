package com.pantano.cinePantanoApplication.configuration.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.WatchMovieGateway
import com.pantano.cinePantanoApplication.core.application.movie.WatchMovieUseCase
import com.pantano.cinePantanoApplication.core.domain.movie.service.WatchMovieService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WatchMovieConfig {

    @Bean
    fun watchMovie(watchMovieGateway: WatchMovieGateway): WatchMovieService {
        return WatchMovieUseCase(watchMovieGateway)
    }
}
