package com.pantano.cinePantanoApplication.gateway.auth.entities

import org.springframework.security.core.GrantedAuthority

enum class UserRoleEntity : GrantedAuthority {
    INTEGRATION {
        override fun getAuthority(): String {
            return "INTEGRATION"
        }
    },
    USER {
        override fun getAuthority(): String {
            return "ROLE_USER"
        }
    }
}
