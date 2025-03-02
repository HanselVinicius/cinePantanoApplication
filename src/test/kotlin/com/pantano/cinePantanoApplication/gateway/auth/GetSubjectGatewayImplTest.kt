package com.pantano.cinePantanoApplication.gateway.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.pantano.cinePantanoApplication.configuration.security.SecurityProperties
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import kotlin.test.Test

class GetSubjectGatewayImplTest {
    @Test
    fun shouldReturnSubjectFromValidToken() {
        val securityProperties = mock(SecurityProperties::class.java)
        val secret = "testSecret"
        val issuer = "testIssuer"
        val subject = "testSubject"
        val token = JWT.create()
            .withIssuer(issuer)
            .withSubject(subject)
            .sign(Algorithm.HMAC256(secret))

        `when`(securityProperties.secret).thenReturn(secret)
        `when`(securityProperties.issuer).thenReturn(issuer)

        val getSubjectGatewayImpl = GetSubjectGatewayImpl(securityProperties)

        val result = getSubjectGatewayImpl.getSubject(token)

        assertEquals(subject, result)
    }
}
