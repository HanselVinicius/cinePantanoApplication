package com.pantano.cinePantanoApplication.entrypoint.http

import com.pantano.cinePantanoApplication.IntegrationTest
import com.pantano.cinePantanoApplication.gateway.auth.entities.AuthEntity
import com.pantano.cinePantanoApplication.gateway.auth.entities.AuthEntityRepository
import com.pantano.cinePantanoApplication.gateway.auth.entities.UserRoleEntity
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@IntegrationTest
class AuthControllerTestIT {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var authEntityRepository: AuthEntityRepository


    @Test
    fun shouldAuthenticate() {
        authEntityRepository.save(AuthEntity(
            principal = "admin",
            credentials = "\$2a\$10\$3mMYqDrGbIYad.niYfW4H.qgcpvI01aVGQQKALZdYp.mqH0vv3Pne",
            roles = UserRoleEntity.INTEGRATION,
            id = null,
            enabled = true
        ))
        mockMvc.perform(
            MockMvcRequestBuilders.post("/v1/auth/authenticate")
                .contentType("application/json")
                .content("{\"principal\":\"admin\",\"credentials\":\"admin\",\"userRole\":\"INTEGRATION\"}")
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk)
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = ["INTEGRATION"])
    fun shouldRegisterUser() {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/v1/auth/register")
                .contentType("application/json")
                .content("{\"principal\":\"TEST\",\"credentials\":\"TEST\",\"userRole\":\"USER\"}")
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk)
    }
}
