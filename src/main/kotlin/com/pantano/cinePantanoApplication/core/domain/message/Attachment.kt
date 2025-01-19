package com.pantano.cinePantanoApplication.core.domain.message

class Attachment(
    val id: Long,
    val attachment: String,
    val name: String,
    val size: Long,
    val url: String
) {
    override fun toString(): String {
        return "Attachment(id=$id, attachment='$attachment', name='$name', size=$size, url='$url')"
    }
}
