package liga.medical.consumer.core.service;

import liga.medical.consumer.core.model.QueueNames;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitListen {

    @RabbitListener(queues = QueueNames.DAILY)
    public void listenDailyQueue(String message) {
        System.out.println("Сообщение: " + message + " получено из очереди " + QueueNames.DAILY);
    }

    @RabbitListener(queues = QueueNames.ALERT)
    public void listenAlertQueue(String message) {
        System.out.println("Сообщение: " + message + " получено из очереди " + QueueNames.ALERT);
    }

    @RabbitListener(queues = QueueNames.ERROR)
    public void listenErrorQueue(String message) {
        System.out.println("Сообщение: " + message + " получено из очереди " + QueueNames.ERROR);
    }
}
