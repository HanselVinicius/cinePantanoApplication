package com.pantano.cinePantanoApplication.gateway.message.entities

import com.pantano.cinePantanoApplication.core.domain.message.vo.MessageType
import com.pantano.cinePantanoApplication.gateway.author.entities.AuthorEntity
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Lob
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import org.hibernate.annotations.SQLRestriction
import java.time.LocalDate

@Entity(name = "message")
@Table(name = "message")
@SQLRestriction("enabled = true")
class MessageEntity(
    @Id
    val id: Long,
    @Lob
    val content: String,
    val channelId: Long,
    val guildId: Long,
    @OneToOne(targetEntity = AuthorEntity::class)
    @JoinColumn(name = "author_id", referencedColumnName = "id", unique = false)
    val author: AuthorEntity,
    val timestamp: LocalDate,
    @OneToMany(targetEntity = AttachmentEntity::class, mappedBy = "messageEntity")
    var attachmentEntity: Set<AttachmentEntity>,
    val type: MessageType,
    val enabled: Boolean,
    val createdAt: LocalDate,
    val updatedAt: LocalDate?
)
