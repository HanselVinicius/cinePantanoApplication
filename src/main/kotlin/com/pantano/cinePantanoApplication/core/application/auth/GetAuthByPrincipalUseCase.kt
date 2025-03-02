package com.pantano.cinePantanoApplication.core.application.auth

import com.pantano.cinePantanoApplication.core.application.gateway.auth.GetAuthByPrincipalGateway
import com.pantano.cinePantanoApplication.core.domain.auth.Auth
import com.pantano.cinePantanoApplication.core.domain.auth.service.GetAuthByPrincipalService

class GetAuthByPrincipalUseCase(private val getAuthByPrincipalGateway: GetAuthByPrincipalGateway) : GetAuthByPrincipalService {
    override fun getAuthByPrincipal(principal: String): Auth {
        return getAuthByPrincipalGateway.getAuthByPrincipal(principal)
    }
}
