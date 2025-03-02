package com.pantano.cinePantanoApplication.configuration.security

import com.pantano.cinePantanoApplication.core.domain.auth.service.GetAuthByPrincipalService
import com.pantano.cinePantanoApplication.core.domain.auth.service.GetSubjectService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

@Configuration
class SecurityFilter(private val getSubjectService: GetSubjectService, private val getAuthByPrincipalService: GetAuthByPrincipalService) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = retrieveToken(request) ?: return filterChain.doFilter(request, response)
        val subject = getSubjectService.getSubject(token)
        val auth = getAuthByPrincipalService.getAuthByPrincipal(subject)
        val authentication = UsernamePasswordAuthenticationToken(
            auth,
            auth.credentials,
            mutableListOf(SimpleGrantedAuthority(auth.roles.name))
        )
        SecurityContextHolder.getContext().authentication = authentication
        filterChain.doFilter(request, response)
    }

    private fun retrieveToken(httpServletRequest: HttpServletRequest): String? {
        return httpServletRequest.getHeader("Authorization").let {
            if (it.isNullOrBlank()) {
                return null
            }
            it.replace("Bearer ", "")
        }
    }
}
