package com.pantano.cinePantanoApplication.core.domain.auth.service

import com.pantano.cinePantanoApplication.core.domain.auth.Auth

interface GetAuthByPrincipalService {
    fun getAuthByPrincipal(principal: String): Auth
}
