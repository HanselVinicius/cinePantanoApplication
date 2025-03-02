package com.pantano.cinePantanoApplication.core.domain.auth

class Auth(
    val id: Long? = null,
    val principal: String,
    var credentials: String,
    val roles: UserRole,
    val enabled: Boolean = true
)
