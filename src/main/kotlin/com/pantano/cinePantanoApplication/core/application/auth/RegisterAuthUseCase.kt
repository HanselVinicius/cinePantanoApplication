package com.pantano.cinePantanoApplication.core.application.auth

import com.pantano.cinePantanoApplication.core.application.gateway.auth.RegisterAuthGateway
import com.pantano.cinePantanoApplication.core.domain.auth.Auth
import com.pantano.cinePantanoApplication.core.domain.auth.service.RegisterAuthService

class RegisterAuthUseCase(private val registerAuthGateway: RegisterAuthGateway) : RegisterAuthService {
    override fun register(auth: Auth) {
        registerAuthGateway.registerAuth(auth)
    }
}
