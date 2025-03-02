package com.pantano.cinePantanoApplication.core.application.auth

import com.pantano.cinePantanoApplication.core.application.gateway.auth.AuthManagerGateway
import com.pantano.cinePantanoApplication.core.domain.auth.Auth
import com.pantano.cinePantanoApplication.core.domain.auth.service.AuthenticateService

class AuthenticateUseCase(private val authManagerGateway: AuthManagerGateway) : AuthenticateService {
    override fun authenticate(auth: Auth): String {
        return authManagerGateway.authenticate(auth)
    }
}
