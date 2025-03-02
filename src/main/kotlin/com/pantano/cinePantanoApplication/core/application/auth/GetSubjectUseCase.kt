package com.pantano.cinePantanoApplication.core.application.auth

import com.pantano.cinePantanoApplication.core.application.gateway.auth.GetSubjectGateway
import com.pantano.cinePantanoApplication.core.domain.auth.service.GetSubjectService

class GetSubjectUseCase(private val getSubjectGateway: GetSubjectGateway) : GetSubjectService {
    override fun getSubject(token: String): String {
        return getSubjectGateway.getSubject(token)
    }
}
