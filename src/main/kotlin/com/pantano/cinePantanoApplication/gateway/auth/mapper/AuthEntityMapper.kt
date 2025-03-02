package com.pantano.cinePantanoApplication.gateway.auth.mapper

import com.pantano.cinePantanoApplication.core.domain.auth.Auth
import com.pantano.cinePantanoApplication.core.domain.auth.UserRole
import com.pantano.cinePantanoApplication.gateway.auth.entities.AuthEntity
import com.pantano.cinePantanoApplication.gateway.auth.entities.UserRoleEntity

object AuthEntityMapper {
    fun toAuth(authEntity: AuthEntity): Auth {
        return Auth(
            id = authEntity.id,
            principal = authEntity.principal,
            credentials = authEntity.credentials,
            roles = UserRole.valueOf(authEntity.roles.name)
        )
    }

    fun toAuthEntity(auth: Auth): AuthEntity {
        return AuthEntity(
            id = auth.id,
            principal = auth.principal,
            credentials = auth.credentials,
            roles = UserRoleEntity.valueOf(auth.roles.name),
            enabled = auth.enabled
        )
    }
}
