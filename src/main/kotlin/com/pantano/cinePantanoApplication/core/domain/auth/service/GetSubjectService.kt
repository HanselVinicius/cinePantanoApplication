package com.pantano.cinePantanoApplication.core.domain.auth.service

interface GetSubjectService {
    fun getSubject(token: String): String
}
