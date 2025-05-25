package com.pantano.cinePantanoApplication.configuration

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableRabbit
class RabbitConfig {
    @Bean
    fun messageConverter(): Jackson2JsonMessageConverter {
        return Jackson2JsonMessageConverter()
    }

    @Bean
    fun messageQueue(): Queue {
        return Queue("messageQueue", true)
    }

    @Bean
    fun messageExchange(): DirectExchange =
        DirectExchange("messageExchange", true, false)

    @Bean
    fun messageBinding(): Binding = BindingBuilder.bind(messageQueue()).to(messageExchange()).withQueueName()


    @Bean
    fun movieQueue(): Queue {
        return Queue("movieQueue", true)
    }

    @Bean
    fun movieExchange(): DirectExchange =
        DirectExchange("movieExchange", true, false)

    @Bean
    fun movieBinding(): Binding = BindingBuilder.bind(movieQueue()).to(movieExchange()).withQueueName()

}
