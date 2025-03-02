package com.pantano.cinePantanoApplication.core.application.auth

import com.pantano.cinePantanoApplication.core.application.gateway.auth.GetAuthByPrincipalGateway
import com.pantano.cinePantanoApplication.core.domain.auth.Auth
import com.pantano.cinePantanoApplication.core.domain.auth.UserRole
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class GetAuthByPrincipalUseCaseTest {
    @Test
    fun shouldReturnAuthByPrincipal() {
        // arrange
        val principal = "principal"
        val auth = Auth(1, principal, "credentials", UserRole.USER)
        val getAuthByPrincipalGateway = mock(GetAuthByPrincipalGateway::class.java)
        `when`(getAuthByPrincipalGateway.getAuthByPrincipal(principal)).thenReturn(auth)
        val getAuthByPrincipalUseCase = GetAuthByPrincipalUseCase(getAuthByPrincipalGateway)
        // act
        val result = getAuthByPrincipalUseCase.getAuthByPrincipal(principal)
        // assert
        assertEquals(auth, result)
    }
}
