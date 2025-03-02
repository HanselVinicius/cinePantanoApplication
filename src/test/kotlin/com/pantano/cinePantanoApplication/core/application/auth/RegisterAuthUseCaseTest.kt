package com.pantano.cinePantanoApplication.core.application.auth

import com.pantano.cinePantanoApplication.core.application.gateway.auth.RegisterAuthGateway
import com.pantano.cinePantanoApplication.core.domain.auth.Auth
import com.pantano.cinePantanoApplication.core.domain.auth.UserRole
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito.mock

class RegisterAuthUseCaseTest {

    @Test
    fun shouldCallRegisterAuthGateway() {
        // arrange
        val auth = Auth(
            id = 1,
            principal = "principal",
            credentials = "credential",
            roles = UserRole.USER,
            enabled = true
        )

        val registerAuthGateway = mock(RegisterAuthGateway::class.java)
        val registerAuthUseCase = RegisterAuthUseCase(registerAuthGateway)
        // act
        registerAuthUseCase.register(auth)

        // assert
        then(registerAuthGateway).should().registerAuth(auth)
    }
}
