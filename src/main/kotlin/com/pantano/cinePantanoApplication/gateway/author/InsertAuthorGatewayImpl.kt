package com.pantano.cinePantanoApplication.gateway.author

import com.pantano.cinePantanoApplication.core.application.gateway.author.InsertAuthorGateway
import com.pantano.cinePantanoApplication.core.domain.author.Author
import com.pantano.cinePantanoApplication.gateway.author.entities.AuthorRepository
import com.pantano.cinePantanoApplication.gateway.author.mapper.AuthorEntityMapper
import org.springframework.stereotype.Component

@Component
class InsertAuthorGatewayImpl(private val authorRepository: AuthorRepository) : InsertAuthorGateway {
    override fun insertAuthor(author: Author) {
        val authorEntity = AuthorEntityMapper.toEntity(author)
        if (authorRepository.existsById(authorEntity.id)) {
            return
        }
        authorRepository.save(authorEntity)
    }
}
