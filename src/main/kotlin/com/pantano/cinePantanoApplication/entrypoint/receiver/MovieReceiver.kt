package com.pantano.cinePantanoApplication.entrypoint.receiver

import com.pantano.cinePantanoApplication.core.domain.movie.factory.MovieFactory
import com.pantano.cinePantanoApplication.core.domain.movie.service.InsertMovieService
import com.pantano.cinePantanoApplication.entrypoint.dto.MovieMessageDto
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class MovieReceiver(val insertMovieService: InsertMovieService, val movieFactory: MovieFactory) {

    @RabbitListener(queues = ["movieQueue"])
    fun receiveMovie(movie: MovieMessageDto) {
        insertMovieService.insertMovie(
            movieFactory.createMovie(
                movie.title,
                LocalDate.of(movie.launchDate.year, movie.launchDate.monthValue, movie.launchDate.dayOfMonth),
                movie.duration
            )
        )
    }
}
