package com.pantano.cinePantanoApplication.core.domain.message

import com.pantano.cinePantanoApplication.core.domain.author.Author
import com.pantano.cinePantanoApplication.core.domain.message.vo.MessageType
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
}
