package com.pantano.cinePantanoApplication.gateway.author

import com.pantano.cinePantanoApplication.core.domain.author.Author
import com.pantano.cinePantanoApplication.gateway.author.entities.AuthorRepository
import com.pantano.cinePantanoApplication.gateway.author.mapper.AuthorEntityMapper
import io.mockk.every
import io.mockk.mockkObject
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.never
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class InsertAuthorGatewayImplTest {

    @Test
    fun shouldInsertAuthor() {
        // arrange
        val authorRepository = mock(AuthorRepository::class.java)
        val insertAuthorGateway = InsertAuthorGatewayImpl(authorRepository)
        val author = Author(1, "name", enabled = true, isBot = false)
        val authorEntity = AuthorEntityMapper.toEntity(author)
        mockkObject(AuthorEntityMapper)
        every { AuthorEntityMapper.toEntity(author) } returns authorEntity

        // act
        insertAuthorGateway.insertAuthor(author)
        // assert
        `when`(authorRepository.save(authorEntity)).thenReturn(authorEntity)
        verify(authorRepository, times(1)).save(authorEntity)
    }

    @Test
    fun shouldNotInsertAuthorIfAlreadyExists() {
        // arrange
        val authorRepository = mock(AuthorRepository::class.java)
        val insertAuthorGateway = InsertAuthorGatewayImpl(authorRepository)
        val author = Author(1, "name", enabled = true, isBot = false)
        val authorEntity = AuthorEntityMapper.toEntity(author)
        // act
        insertAuthorGateway.insertAuthor(author)
        // assert
        `when`(authorRepository.existsById(authorEntity.id)).thenReturn(true)
        verify(authorRepository, never()).save(authorEntity)
    }
}
