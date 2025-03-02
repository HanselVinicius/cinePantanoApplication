package com.pantano.cinePantanoApplication.gateway.auth

import com.pantano.cinePantanoApplication.core.application.gateway.auth.RegisterAuthGateway
import com.pantano.cinePantanoApplication.core.domain.auth.Auth
import com.pantano.cinePantanoApplication.gateway.auth.entities.AuthEntityRepository
import com.pantano.cinePantanoApplication.gateway.auth.mapper.AuthEntityMapper
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class RegisterAuthGatewayImpl(private val authEntityRepository: AuthEntityRepository, private val passwordEncoder: PasswordEncoder) : RegisterAuthGateway {
    override fun registerAuth(auth: Auth) {
        auth.credentials = passwordEncoder.encode(auth.credentials)
        authEntityRepository.save(AuthEntityMapper.toAuthEntity(auth))
    }
}
