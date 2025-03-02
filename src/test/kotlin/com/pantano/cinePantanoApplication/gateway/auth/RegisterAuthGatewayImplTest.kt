package com.pantano.cinePantanoApplication.gateway.auth

import com.pantano.cinePantanoApplication.core.domain.auth.Auth
import com.pantano.cinePantanoApplication.core.domain.auth.UserRole
import com.pantano.cinePantanoApplication.gateway.auth.entities.AuthEntity
import com.pantano.cinePantanoApplication.gateway.auth.entities.AuthEntityRepository
import com.pantano.cinePantanoApplication.gateway.auth.entities.UserRoleEntity
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito.any
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class RegisterAuthGatewayImplTest {
    @Test
    fun shouldRegisterAuth() {
        // arrange
        val authEntityRepository = mock(AuthEntityRepository::class.java)
        val authEntity = AuthEntity(
            id = 1,
            principal = "principal",
            credentials = "credential",
            roles = UserRoleEntity.USER,
            enabled = true
        )
        val auth = Auth(
            id = 1,
            principal = "principal",
            credentials = "credential",
            roles = UserRole.USER,
            enabled = true
        )
        `when`(authEntityRepository.save(any(AuthEntity::class.java))).thenReturn(authEntity)
        val registerAuthGatewayImpl = RegisterAuthGatewayImpl(authEntityRepository, BCryptPasswordEncoder())
        // act
        registerAuthGatewayImpl.registerAuth(auth)
        // assert
        then(authEntityRepository).should().save(any(AuthEntity::class.java))
    }
}
