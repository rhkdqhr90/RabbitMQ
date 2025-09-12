package org.example.rabbitmessagequeue.step4;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class NewsPublisher {
    private final RabbitTemplate rabbitTemplate;

    public NewsPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    private String publisherMessage(String news, String messageSuffix) {
        String message = news + messageSuffix;
        rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE_FOR_NEWS,news, message);
        System.out.println("publisherMessage: " + message);
        return message;
    }

    public String publish(String news) {
        return publisherMessage(news, "관련 새 소식이 있어요!");
    }
    public String publishAPI(String news) {
        return publisherMessage(news, "- 관련 새 소식이 나왔습니다.(API)");
    }

}
