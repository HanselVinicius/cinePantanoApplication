package com.pantano.cinePantanoApplication.entrypoint.dto

import java.io.Serializable
import java.time.LocalDateTime

data class MovieMessageDto(
    val title: String,
    val launchDate: LocalDateTime,
    val duration: Int
) : Serializable
