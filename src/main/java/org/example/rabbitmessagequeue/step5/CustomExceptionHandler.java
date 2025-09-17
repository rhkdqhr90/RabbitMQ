//package org.example.rabbitmessagequeue.step5;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomExceptionHandler {
//    private final LogPublisher logPublisher;
//
//    public CustomExceptionHandler(LogPublisher logPublisher) {
//        this.logPublisher = logPublisher;
//    }
//    //에러 로그 처리
//    public void handlerException(Exception e) {
//        String message = e.getMessage();
//        String routingKey;
//        if( e instanceof NullPointerException ){
//            routingKey = "log.error";
//        }else if(e instanceof IllegalArgumentException){
//            routingKey = "log.warn";
//        }else{
//            routingKey = "log.error";
//        }
//        logPublisher.publish(routingKey, "Error Log:" + message);
//    }
//
//    public void handlerMessage(String message) {
//        String routingKey = "log.info";
//        logPublisher.publish(routingKey, "Info Log:" + message);
//    }
//}
