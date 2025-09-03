//package org.example.rabbitmessagequeue.step2;
//
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class WorkQueueController {
//
//    private final WorkQueueProducer workQueueProducer;
//
//    public WorkQueueController(WorkQueueProducer workQueueProducer) {
//        this.workQueueProducer = workQueueProducer;
//    }
//    @PostMapping("/workqueue")
//    public String sendMessage(@RequestParam String message, @RequestParam int duration) {
//        workQueueProducer.sendWorkQueue(message, duration);
//        return "[#] work queue sent = "+message + ",(" + duration + ")";
//    }
//}
