package com.pantano.cinePantanoApplication.gateway.message.mapper

import com.pantano.cinePantanoApplication.core.domain.message.Attachment
import com.pantano.cinePantanoApplication.gateway.message.entities.AttachmentEntity
import java.time.LocalDate

object AttachmentEntityMapper {

    fun toEntity(attachment: Attachment): AttachmentEntity {
        return AttachmentEntity(
            id = attachment.id,
            attachment = attachment.attachment,
            name = attachment.name,
            size = attachment.size,
            url = attachment.url,
            createdAt = LocalDate.now(),
            updatedAt = null,
            enabled = true,
            messageEntity = null
        )
    }
}
