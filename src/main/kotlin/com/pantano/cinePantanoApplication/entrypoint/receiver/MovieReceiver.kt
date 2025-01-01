package com.pantano.cinePantanoApplication.entrypoint.receiver

import com.pantano.cinePantanoApplication.entrypoint.dto.MovieMessageDto
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class MovieReceiver {

    @RabbitListener(queues = ["movieQueue"])
    fun receiveMovie(movie: MovieMessageDto) {
        println("Received movie: $movie")
    }
}
