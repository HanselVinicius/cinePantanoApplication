package com.pantano.cinePantanoApplication.core.application.auth

import com.pantano.cinePantanoApplication.core.application.gateway.auth.GetSubjectGateway
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import kotlin.test.assertEquals

class GetSubjectUseCaseTest {

    @Test
    fun shouldCallGetSubjectGatewayToReturnToken() {
        // arrange
        val getSubjectGateway = mock(GetSubjectGateway::class.java)
        `when`(getSubjectGateway.getSubject("token")).thenReturn("subject")
        // act
        val getSubjectUseCase = GetSubjectUseCase(getSubjectGateway)
        val result = getSubjectUseCase.getSubject("token")
        // assert
        assertEquals("subject", result)
    }
}
