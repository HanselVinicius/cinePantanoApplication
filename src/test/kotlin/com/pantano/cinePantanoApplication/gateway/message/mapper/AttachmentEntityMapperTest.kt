package com.pantano.cinePantanoApplication.gateway.message.mapper

import com.pantano.cinePantanoApplication.core.domain.message.Attachment
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.LocalDate

class AttachmentEntityMapperTest {
    @Test
    fun shouldMapDomainToEntity() {
        // arrange
        val attachment = Attachment(0, "attachment", "name", 10, "url")
        // act
        val attachmentEntity = AttachmentEntityMapper.toEntity(attachment)
        // assert
        assertEquals(attachment.id, attachmentEntity.id)
        assertEquals(attachment.attachment, attachmentEntity.attachment)
        assertEquals(attachment.name, attachmentEntity.name)
        assertEquals(attachment.size, attachmentEntity.size)
        assertEquals(attachment.url, attachmentEntity.url)
        assertEquals(LocalDate.now(), attachmentEntity.createdAt)
        assertNull(attachmentEntity.updatedAt)
        assertTrue(attachmentEntity.enabled)
        assertNull(attachmentEntity.messageEntity)
    }
}
