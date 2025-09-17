//package org.example.rabbitmessagequeue.step8;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.retry.support.RetryTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class OrderConsumer {
//    private final RabbitTemplate rabbitTemplate;
//    private final RetryTemplate retryTemplate;
//
//    public OrderConsumer(RabbitTemplate rabbitTemplate, RetryTemplate retryTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//        this.retryTemplate = retryTemplate;
//    }
//
//    @RabbitListener(queues = RabbitMQConfig.ORDER_COMPLETED_QUEUE)
//    public void consumer(String message) {
//        retryTemplate.execute(context -> {
//            try{
//                System.out.println("# 리시브 메세지 " + message + " # retry" +context.getRetryCount());
//                if("fail".equals(message)){
//                    throw new RuntimeException(message);
//                }
//                System.out.println("# 메세지 처러 성공 " + message);
//            }catch (Exception e){
//                if(context.getRetryCount() >= 2){
//                    rabbitTemplate.convertAndSend(RabbitMQConfig.ORDER_TOPIC_DLX, RabbitMQConfig.DEAD_LETTER_ROUTING_KEY, message);
//                }else{
//                    throw e;
//                }
//            }
//            return null;
//        });
//    }
//}
