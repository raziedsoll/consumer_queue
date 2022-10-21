package liga.medical.consumer.core.configuration;

import liga.medical.consumer.core.model.QueueNames;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    private static final String HOST = "hostrabbitmq";

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(HOST);
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean("dailyQueue")
    public Queue getDailyQueue() {
        return new Queue(QueueNames.DAILY);
    }

    @Bean("alertQueue")
    public Queue getAlertQueue() {
        return new Queue(QueueNames.ALERT);
    }

    @Bean("errorQueue")
    public Queue getErrorQueue() {
        return new Queue(QueueNames.ERROR);
    }
}
