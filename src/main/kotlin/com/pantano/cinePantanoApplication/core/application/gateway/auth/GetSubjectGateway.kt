package com.pantano.cinePantanoApplication.core.application.gateway.auth

interface GetSubjectGateway {
    fun getSubject(token: String): String
}
