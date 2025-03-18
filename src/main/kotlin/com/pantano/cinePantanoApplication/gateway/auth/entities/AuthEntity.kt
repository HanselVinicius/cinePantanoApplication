package com.pantano.cinePantanoApplication.gateway.auth.entities

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.SQLRestriction
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity(name = "auth")
@Table(name = "auth")
@SQLRestriction("enabled = true")
class AuthEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val principal: String,
    val credentials: String,
    val enabled: Boolean,
    @Enumerated(EnumType.STRING)
    val roles: UserRoleEntity
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(roles)
    }

    override fun getPassword(): String {
        return credentials
    }

    override fun getUsername(): String {
        return principal
    }

    override fun isEnabled(): Boolean {
        return enabled
    }

    override fun toString(): String {
        return "AuthEntity(id=$id, principal='$principal', credentials='$credentials', enabled=$enabled, roles=$roles)"
    }
}
