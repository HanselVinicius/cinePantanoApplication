package com.pantano.cinePantanoApplication.configuration.movie

import com.pantano.cinePantanoApplication.core.application.gateway.movie.GetMovieGateway
import com.pantano.cinePantanoApplication.core.application.movie.GetMoviesUseCase
import com.pantano.cinePantanoApplication.core.domain.movie.service.GetMovieService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GetMovieConfig {

    @Bean
    fun getMovies(getMovieGateway: GetMovieGateway): GetMovieService {
        return GetMoviesUseCase(getMovieGateway)
    }
}
