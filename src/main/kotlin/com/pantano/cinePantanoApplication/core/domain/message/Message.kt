package com.pantano.cinePantanoApplication.core.domain.message

import com.pantano.cinePantanoApplication.core.domain.author.Author
import com.pantano.cinePantanoApplication.core.domain.message.vo.MessageType
import com.pantano.cinePantanoApplication.core.domain.movie.Movie
import com.pantano.cinePantanoApplication.core.domain.movie.factory.MovieFactory
import java.time.LocalDate

class Message(
    val id: Long,
    val content: String,
    val channelId: Long,
    val guildId: Long,
    val author: Author,
    val timestamp: LocalDate,
    val attachment: Set<Attachment?>,
    val messageType: MessageType
) {
    override fun toString(): String {
        return "Message(id=$id, content='$content', channelId=$channelId, guildId=$guildId, author=$author, timestamp=$timestamp, attachment=$attachment)"
    }

    fun createMovieFromMessage(): Movie {
        var image: String? = null
        if (this.attachment.isNotEmpty()) {
            image = this.attachment.first()?.url
        }

        val movieFactory = MovieFactory()
        return movieFactory.createMovie(
            title = this.content,
            launchDate = LocalDate.of(this.timestamp.year, this.timestamp.monthValue, this.timestamp.dayOfMonth),
            duration = 0,
            image = image
        )
    }
}
