//package org.example.rabbitmessagequeue.step2;
//
//
//import org.springframework.amqp.core.AcknowledgeMode;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConfig {
//    public static final String QueueName = "WorkQueue";
//
//    @Bean
//    public Queue queue() {
//        return new Queue(QueueName, true);
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        return new RabbitTemplate(connectionFactory);
//    }
//
//    @Bean
//    public SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory,
//                                                                         MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(QueueName);
//        container.setMessageListener(listenerAdapter);
//        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
//        return container;
//    }
//
//    @Bean
//    public MessageListenerAdapter listenerAdapter(WorkQueueConsumer workQueueTask) {
//        return new MessageListenerAdapter(workQueueTask, "workQueueTask");
//    }
//}
