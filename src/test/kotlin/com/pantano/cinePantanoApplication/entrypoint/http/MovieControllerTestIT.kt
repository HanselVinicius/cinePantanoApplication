package com.pantano.cinePantanoApplication.entrypoint.http

import com.pantano.cinePantanoApplication.IntegrationTest
import com.pantano.cinePantanoApplication.gateway.auth.entities.AuthEntity
import com.pantano.cinePantanoApplication.gateway.auth.entities.AuthEntityRepository
import com.pantano.cinePantanoApplication.gateway.auth.entities.UserRoleEntity
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntity
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntityRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate

@IntegrationTest
class MovieControllerTestIT {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var movieEntityRepository: MovieEntityRepository

    @Autowired
    lateinit var authEntityRepository: AuthEntityRepository

    @BeforeEach
    fun beforeEach() {
        authEntityRepository.save(
            AuthEntity(
                principal = "admin",
                credentials = "\$2a\$10\$3mMYqDrGbIYad.niYfW4H.qgcpvI01aVGQQKALZdYp.mqH0vv3Pne",
                roles = UserRoleEntity.INTEGRATION,
                id = null,
                enabled = true
            )
        )
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = ["INTEGRATION"])
    fun getMovies() {
        this.movieEntityRepository.save(
            MovieEntity(
                enabled = true,
                id = null,
                title = "Test",
                launchDate = LocalDate.now(),
                duration = 120,
                image = "image",
                createdAt = LocalDate.now(),
                updatedAt = LocalDate.now(),
                review = null
            )
        )
        mockMvc.perform(
            MockMvcRequestBuilders.get("/v1/movie?page=0&limit=1")
                .contentType("application/json")
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk)
            .andExpect(content().string("[{\"id\":1,\"title\":\"Test\",\"launchDate\":[2025,3,17],\"duration\":120,\"review\":[],\"image\":\"image\",\"enabled\":true,\"movieStatus\":\"TO_WATCH\"}]"))
    }
}
