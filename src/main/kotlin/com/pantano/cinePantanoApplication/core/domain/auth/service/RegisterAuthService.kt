package com.pantano.cinePantanoApplication.core.domain.auth.service

import com.pantano.cinePantanoApplication.core.domain.auth.Auth

interface RegisterAuthService {
    fun register(auth: Auth)
}
