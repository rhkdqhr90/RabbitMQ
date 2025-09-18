package org.example.rabbitmessagequeue.step10;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
@RequiredArgsConstructor
public class TransactionController {

    private final MessageProducer messageProducer;

    @PostMapping
    public ResponseEntity<String> publishMessage(@RequestBody StockEntity stockEntity, @RequestParam boolean testcase) {
        System.out.println("Publish Confirms Send message : " + stockEntity);

        try {
            messageProducer.sendMessage(stockEntity, testcase);
            return ResponseEntity.ok("Message sent successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Publisher Confirms 트랜잭션 실패: "+e.getMessage());
        }
    }

}
