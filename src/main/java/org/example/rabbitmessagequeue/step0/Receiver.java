package org.example.rabbitmessagequeue.step0;

import org.springframework.stereotype.Component;

@Component
public class Receiver {
    public void receiveMessage(String message) {
        System.out.println("[#] Receiver" + message);
    }
}
