package org.example.rabbitmessagequeue.step10;

import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MessageConsumer {
    private final StockRepository stockRepository;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME, containerFactory = "rabbitListenerContainerFactory")
    public void receiveMessage(StockEntity stockEntity, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) {
       try{
           System.out.println("[consumer] Receive message : " + stockEntity);
           Optional<StockEntity> optional = stockRepository.findById(stockEntity.getId());
           if(optional.isPresent()){
               StockEntity OptionsstockEntity = optional.get();
               OptionsstockEntity.setUpdatedAt(LocalDateTime.now());
               stockRepository.save(OptionsstockEntity);
               System.out.println("[Save Entity Consumer]" + OptionsstockEntity);

           }

           channel.basicAck(deliveryTag, false);

       }catch (Exception e){
           System.out.println("[Consumer Exception]" +e.getMessage());
           try{
               channel.basicNack(deliveryTag,false,false);
           } catch (IOException ex) {
               System.out.println("[Consumer send nack]" + ex.getMessage());
               throw new RuntimeException(ex);
           }
       }

    }
}
