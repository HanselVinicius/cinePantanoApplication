package com.pantano.cinePantanoApplication.entrypoint.http

import com.pantano.cinePantanoApplication.core.domain.auth.Auth
import com.pantano.cinePantanoApplication.core.domain.auth.service.AuthenticateService
import com.pantano.cinePantanoApplication.core.domain.auth.service.RegisterAuthService
import com.pantano.cinePantanoApplication.entrypoint.http.dto.AuthDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/auth")
class AuthController(private val authenticateService: AuthenticateService, private val registerAuthService: RegisterAuthService) {

    @PostMapping("/authenticate")
    fun authenticate(@RequestBody autDto: AuthDto): String {
        return authenticateService.authenticate(
            Auth(
                principal = autDto.principal,
                credentials = autDto.credentials,
                roles = autDto.userRole
            )
        )
    }

    //    @SecurityRequirement(name = "bearer-key")
    @PostMapping("/register")
    fun register(@RequestBody autDto: AuthDto) {
        registerAuthService.register(
            Auth(
                principal = autDto.principal,
                credentials = autDto.credentials,
                roles = autDto.userRole
            )
        )
    }
}
