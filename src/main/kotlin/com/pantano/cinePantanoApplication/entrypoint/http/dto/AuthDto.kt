package com.pantano.cinePantanoApplication.entrypoint.http.dto

import com.pantano.cinePantanoApplication.core.domain.auth.UserRole

data class AuthDto(
    val principal: String,
    val credentials: String,
    val userRole: UserRole
)
