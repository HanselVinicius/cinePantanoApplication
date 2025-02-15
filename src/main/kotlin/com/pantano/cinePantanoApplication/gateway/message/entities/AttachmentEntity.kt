package com.pantano.cinePantanoApplication.gateway.message.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.SQLRestriction
import java.time.LocalDate

@Entity(name = "attachment")
@Table(name = "attachment")
@SQLRestriction("enabled = true")
class AttachmentEntity(
    @Id
    val id: Long,
    val attachment: String,
    val name: String,
    val size: Long,
    val url: String,
    @ManyToOne(targetEntity = MessageEntity::class)
    @JoinColumn(name = "message_id", referencedColumnName = "id")
    var messageEntity: MessageEntity?,
    val enabled: Boolean,
    val createdAt: LocalDate,
    val updatedAt: LocalDate?
)
