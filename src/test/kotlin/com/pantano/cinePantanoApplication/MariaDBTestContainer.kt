package com.pantano.cinePantanoApplication

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.testcontainers.containers.GenericContainer
import org.testcontainers.utility.DockerImageName
import java.util.concurrent.atomic.AtomicBoolean

class MariaDBTestContainer : BeforeAllCallback {

    companion object {
        var containerStarted = AtomicBoolean(false)
        val mariaDBContainer: GenericContainer<*> = GenericContainer(DockerImageName.parse("mariadb")).withExposedPorts(3306)
            .withEnv("MYSQL_ROOT_PASSWORD", "mariadbrootPW")
    }

    override fun beforeAll(context: ExtensionContext?) {
        if (containerStarted.get()) {
            return
        }
        mariaDBContainer.start()
        System.setProperty("spring.datasource.url", "jdbc:mariadb://${mariaDBContainer.host}:${mariaDBContainer.getMappedPort(3306)}/pantano?createDatabaseIfNotExist=true")
        System.setProperty("spring.datasource.username", "root")
        System.setProperty("spring.datasource.password", "mariadbrootPW")
        containerStarted.set(true)
    }
}
