//package org.example.rabbitmessagequeue.step8;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/order")
//public class OrderController {
//    private final OrderProducer orderProducer;
//
//    public OrderController(OrderProducer orderProducer) {
//        this.orderProducer = orderProducer;
//    }
//
//    @GetMapping
//    public ResponseEntity<String> sendOrderMessage(@RequestParam String message) {
//
//        orderProducer.sendShipping(message);
//        return ResponseEntity.ok("Order Completed Message sent: " + message);
//    }
//}
