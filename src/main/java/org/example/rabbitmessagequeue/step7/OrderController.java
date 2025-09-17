//package org.example.rabbitmessagequeue.step7;
//
//import org.springframework.http.ResponseEntity;
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
//    @RequestMapping
//    public ResponseEntity<String> sendOrderMessage(@RequestParam String message){
//        orderProducer.SendShippingOrder(message);
//        return ResponseEntity.ok("Order Completed Message Sent" + message);
//
//    }
//
//}
