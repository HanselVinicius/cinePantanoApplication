package com.pantano.cinePantanoApplication.core.application.gateway.auth

import com.pantano.cinePantanoApplication.core.domain.auth.Auth

interface RegisterAuthGateway {
    fun registerAuth(auth: Auth)
}
