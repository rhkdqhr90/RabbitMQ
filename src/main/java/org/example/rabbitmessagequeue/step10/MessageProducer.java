package org.example.rabbitmessagequeue.step10;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final StockRepository stockRepository;

    @Transactional
    public void sendMessage(StockEntity stockEntity, boolean testCase) {
        stockEntity.setProcessed(false);
        stockEntity.setCreatedAt(LocalDateTime.now());
        StockEntity entity = stockRepository.save(stockEntity);

        System.out.println("[producer] Send message : " + entity);

        if (stockEntity.getId() == null || stockEntity.getId().describeConstable().isEmpty()) {
            throw new RuntimeException("User id is required");
        }

        try{
            CorrelationData correlationData = new CorrelationData(entity.getId().toString());
            rabbitTemplate.convertAndSend(testCase ? "nonExistentExchange" :RabbitMQConfig.EXCHANGE_NAME,testCase ? "invalidRoutingKey" : RabbitMQConfig.ROUTING_KEY, entity, correlationData);

            if(correlationData.getFuture().get(5, TimeUnit.SECONDS).isAck()){
                System.out.println("[Producer correlationData] 성공 " + entity);
                entity.setProcessed(true);
                stockRepository.save(entity);
            }else{
                throw new RuntimeException("#confirm 실패 - 롤백");
            }
        } catch (Exception e) {
            System.out.println("[Producer Exception fail[" + e);

        }


    }
}
