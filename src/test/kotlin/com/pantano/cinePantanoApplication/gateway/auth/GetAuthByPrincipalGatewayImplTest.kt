package com.pantano.cinePantanoApplication.gateway.auth

import com.pantano.cinePantanoApplication.gateway.auth.entities.AuthEntity
import com.pantano.cinePantanoApplication.gateway.auth.entities.AuthEntityRepository
import com.pantano.cinePantanoApplication.gateway.auth.entities.UserRoleEntity
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class GetAuthByPrincipalGatewayImplTest {

    @Test
    fun shouldGetAuthByPrincipal() {
        // arrange
        val principal = "principal"
        val authEntityRepository = mock(AuthEntityRepository::class.java)
        val authEntityMock = AuthEntity(
            id = 1,
            principal = principal,
            credentials = "credential",
            roles = UserRoleEntity.USER,
            enabled = true
        )
        `when`(authEntityRepository.findByPrincipal(principal)).thenReturn(authEntityMock)
        val getAuthByPrincipalGatewayImpl = GetAuthByPrincipalGatewayImpl(authEntityRepository)
        // act
        getAuthByPrincipalGatewayImpl.getAuthByPrincipal(principal)
        // assert
        then(authEntityRepository).should().findByPrincipal(principal)
    }
}
