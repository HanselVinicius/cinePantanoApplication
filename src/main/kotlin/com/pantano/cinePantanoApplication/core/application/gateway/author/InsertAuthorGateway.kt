package com.pantano.cinePantanoApplication.core.application.gateway.author

import com.pantano.cinePantanoApplication.core.domain.author.Author

interface InsertAuthorGateway {
    fun insertAuthor(author: Author)
}
