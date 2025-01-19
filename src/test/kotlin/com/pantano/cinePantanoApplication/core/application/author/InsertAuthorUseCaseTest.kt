package com.pantano.cinePantanoApplication.core.application.author

import com.pantano.cinePantanoApplication.core.application.gateway.author.InsertAuthorGateway
import com.pantano.cinePantanoApplication.core.domain.author.Author
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class InsertAuthorUseCaseTest {
    @Test
    fun shouldCallGatewayToInsertAuthor() {
        // arrange
        val author = Author(id = 1, name = "name", enabled = true, isBot = true)
        val insertAuthorGateway = mock(InsertAuthorGateway::class.java)
        val insertAuthorUseCase = InsertAuthorUseCase(insertAuthorGateway)
        // act
        insertAuthorUseCase.insertAuthor(author)
        // assert
        verify(insertAuthorGateway).insertAuthor(author)
    }
}
