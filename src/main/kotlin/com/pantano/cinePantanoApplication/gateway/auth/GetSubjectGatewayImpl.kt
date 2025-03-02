package com.pantano.cinePantanoApplication.gateway.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.pantano.cinePantanoApplication.configuration.security.SecurityProperties
import com.pantano.cinePantanoApplication.core.application.gateway.auth.GetSubjectGateway
import org.springframework.stereotype.Component

@Component
class GetSubjectGatewayImpl(private val securityProperties: SecurityProperties) : GetSubjectGateway {
    override fun getSubject(token: String): String {
        val algorithm = Algorithm.HMAC256(securityProperties.secret)
        return JWT.require(algorithm)
            .withIssuer(securityProperties.issuer)
            .build()
            .verify(token)
            .subject
    }
}
