package com.pantano.cinePantanoApplication.entrypoint.http

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension::class)
class AuthControllerTestIT {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun shouldAuthenticate() {
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
    fun shouldInsertUser(){
        mockMvc.perform(
            MockMvcRequestBuilders.post("/v1/auth/register")
                .contentType("application/json")
                .content("{\"principal\":\"TEST\",\"credentials\":\"TEST\",\"userRole\":\"USER\"}")
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk)
    }
}
