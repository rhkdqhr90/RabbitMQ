package org.example.rabbitmessagequeue.step3;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class StompController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public StompController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/send")
    public void sendMessage(NotificationMessage notificationMessage){
        //수신된 메세지를 브로드 캐스팅
        String message = notificationMessage.getMessage();
        System.out.println("[#] Sending message: " + message);
        //클라이언트  메세지 브로드 캐스팅
        simpMessagingTemplate.convertAndSend("/topic/notifications",message);
    }
}
