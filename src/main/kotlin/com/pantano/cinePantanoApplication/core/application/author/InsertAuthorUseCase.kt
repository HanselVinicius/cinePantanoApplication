package com.pantano.cinePantanoApplication.core.application.author

import com.pantano.cinePantanoApplication.core.application.gateway.author.InsertAuthorGateway
import com.pantano.cinePantanoApplication.core.domain.author.Author
import com.pantano.cinePantanoApplication.core.domain.author.service.InsertAuthorService

class InsertAuthorUseCase(
    private val insertAuthorGateway: InsertAuthorGateway
) : InsertAuthorService {
    override fun insertAuthor(author: Author) {
        author.enabled = true
        insertAuthorGateway.insertAuthor(author)
    }
}
