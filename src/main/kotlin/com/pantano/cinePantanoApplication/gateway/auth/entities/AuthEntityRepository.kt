package com.pantano.cinePantanoApplication.gateway.auth.entities

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthEntityRepository : JpaRepository<AuthEntity, Long> {
    fun findByPrincipal(principal: String): AuthEntity
}
