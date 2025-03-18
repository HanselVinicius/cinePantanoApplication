package com.pantano.cinePantanoApplication.gateway.auth

import com.pantano.cinePantanoApplication.core.application.gateway.auth.GetAuthByPrincipalGateway
import com.pantano.cinePantanoApplication.core.domain.auth.Auth
import com.pantano.cinePantanoApplication.gateway.auth.entities.AuthEntity
import com.pantano.cinePantanoApplication.gateway.auth.entities.AuthEntityRepository
import com.pantano.cinePantanoApplication.gateway.auth.mapper.AuthEntityMapper
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class GetAuthByPrincipalGatewayImpl(private val authEntityRepository: AuthEntityRepository) : GetAuthByPrincipalGateway, UserDetailsService {
    override fun getAuthByPrincipal(principal: String): Auth {
        val authEntity = loadUserByUsername(principal) as AuthEntity
        return AuthEntityMapper.toAuth(authEntity)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val result = authEntityRepository.findByPrincipal(username!!)
        return result
    }
}
