package ar.edu.unrn.shoppingservice.domain.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ProducerConfig.
 */
@Configuration
public class ProducerConfig {

    @Value("${rabbit.queue.name}")
    private String message;

    public ProducerConfig() {
    }

    @Bean
    public Queue queue() {
        return new Queue(message, true);
    }
}