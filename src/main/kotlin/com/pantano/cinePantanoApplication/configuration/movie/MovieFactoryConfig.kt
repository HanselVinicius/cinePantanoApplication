package com.pantano.cinePantanoApplication.configuration.movie

import com.pantano.cinePantanoApplication.core.domain.movie.factory.MovieFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MovieFactoryConfig {

    @Bean
    fun movieFactory(): MovieFactory {
        return MovieFactory()
    }
}
