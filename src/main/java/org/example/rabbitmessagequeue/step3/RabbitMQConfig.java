//package org.example.rabbitmessagequeue.step3;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.FanoutExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConfig {
//    public static final String QUEUE_NAME = "notification_queue";
//    public static final String FANOUT_EXCHANGE = "notificationExchange";
//
//    @Bean
//    public Queue notificationQueue() {
//        return new Queue(QUEUE_NAME,false);
//    }
//
//    @Bean
//    public FanoutExchange notificationExchange() {
//        //메세지를 수신하면 연결된 모든 큐로 브로드캐스트
//        return new FanoutExchange(FANOUT_EXCHANGE);
//    }
//
//    @Bean
//    public Binding notificationBinding(Queue notificationQueue, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(notificationQueue).to(fanoutExchange);
//    }
//}
