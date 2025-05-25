package com.pantano.cinePantanoApplication

import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@ExtendWith(
    value = [
        MariaDBTestContainer::class,
        RabbitMQTestContainer::class,
        SpringExtension::class
    ]
)
@AutoConfigureMockMvc
@AutoConfigureWebMvc
@ImportAutoConfiguration
@SpringBootTest(classes = [CinePantanoApplication::class])
annotation class IntegrationTest()
