package com.pantano.cinePantanoApplication

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.testcontainers.containers.GenericContainer
import org.testcontainers.utility.DockerImageName
import java.util.concurrent.atomic.AtomicBoolean

class RabbitMQTestContainer : BeforeAllCallback {

    companion object {
        var containerStarted = AtomicBoolean(false)
        val rabbitMQContainer: GenericContainer<*> = GenericContainer(DockerImageName.parse("rabbitmq:3-management"))
            .withExposedPorts(5672, 15672)
            .withEnv("RABBITMQ_DEFAULT_USER", "guest")
            .withEnv("RABBITMQ_DEFAULT_PASS", "guest")
    }

    override fun beforeAll(context: ExtensionContext?) {
        if (containerStarted.get()) {
            return
        }
        rabbitMQContainer.start()
        System.setProperty("spring.rabbitmq.addresses", "${rabbitMQContainer.host}:${rabbitMQContainer.getMappedPort(5672)}")
        System.setProperty("spring.rabbitmq.username", "guest")
        System.setProperty("spring.rabbitmq.password", "guest")
        containerStarted.set(true)
    }
}
