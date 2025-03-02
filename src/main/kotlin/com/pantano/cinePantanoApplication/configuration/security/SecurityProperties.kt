package com.pantano.cinePantanoApplication.configuration.security

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class SecurityProperties {

    @Value("\${security.jwt.secret}")
    lateinit var secret: String

    @Value("\${security.token.issuer}")
    lateinit var issuer: String
}
