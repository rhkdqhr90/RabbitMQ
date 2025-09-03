package org.example.rabbitmessagequeue.step3;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationSubscriber {

    public static final String CLIENT_URL = "/topic/notifications";

    private final SimpMessagingTemplate simpMessagingTemplate;

    public NotificationSubscriber(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void subscribe(String message) {
        //RabbitMQ Queue 에서 메세지 수신
        // String message = (String) rabbitTemplate.receiveAndConvert(RabbitMQConfig,QUEUE.NAME)
      System.out.println("[#] Received notification: " + message);
      simpMessagingTemplate.convertAndSend(CLIENT_URL, message);
        System.out.println("[#] Sent to WebSocket clients: " + CLIENT_URL + " -> " + message);
    }

}
