//package org.example.rabbitmessagequeue.step1;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Sender {
//
//    private final RabbitTemplate rabbitTemplate;
//
//    public Sender(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    public void send(String message) {
//        rabbitTemplate.convertAndSend(RabbitMQConfig.QueueName, message);
//        System.out.println("[#] Sent: " + message);
//    }
//}
