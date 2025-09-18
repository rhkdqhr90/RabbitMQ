//package org.example.rabbitmessagequeue.step9;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
//@Component
//@RequiredArgsConstructor
//public class MessageConsumer {
//    private final StockRepository stockRepository;
//
//    @RabbitListener(queues = "transactionQueue")
//    public void receiveTransactionMessage(StockEntity stockEntity){
//        System.out.println("#Message Received : " + stockEntity);
//        try{
//            stockEntity.setProcessed(true);
//            stockEntity.setUpdatedAt(LocalDateTime.now());
//            stockRepository.save(stockEntity);
//            System.out.println("StockEntity 저장 완료");
//        } catch (Exception e){
//            System.out.println("# Entity 수정 에러 " + e.getMessage());
//            throw e;
//        }
//    }
//}
