package com.pantano.cinePantanoApplication.core.domain.auth.service

import com.pantano.cinePantanoApplication.core.domain.auth.Auth

interface AuthenticateService {
    fun authenticate(auth: Auth): String
}
