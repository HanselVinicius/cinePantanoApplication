package com.pantano.cinePantanoApplication.gateway.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.pantano.cinePantanoApplication.configuration.security.SecurityProperties
import com.pantano.cinePantanoApplication.core.application.gateway.auth.AuthManagerGateway
import com.pantano.cinePantanoApplication.core.domain.auth.Auth
import com.pantano.cinePantanoApplication.gateway.auth.entities.AuthEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Component

@Component
class AuthManagerGatewayImpl(private val authenticationManager: AuthenticationManager, private val securityProperties: SecurityProperties) : AuthManagerGateway {
    override fun authenticate(auth: Auth): String {
        val token = authenticationManager.authenticate(UsernamePasswordAuthenticationToken(auth.principal, auth.credentials))
        return generateToken(token.principal as AuthEntity)
    }

    private fun generateToken(authEntity: AuthEntity): String {
        val algorithm = Algorithm.HMAC256(securityProperties.secret)
        return JWT.create()
            .withIssuer(securityProperties.issuer)
            .withSubject(authEntity.principal)
            .sign(algorithm)
    }
}
