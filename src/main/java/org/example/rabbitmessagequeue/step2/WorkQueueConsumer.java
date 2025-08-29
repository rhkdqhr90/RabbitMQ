package org.example.rabbitmessagequeue.step2;

import org.springframework.stereotype.Component;

@Component
public class WorkQueueConsumer {
    public void workQueueTask(String message) {
        String[] messageParts = message.split("\\|");
        String originMessage = messageParts[0];
        int duration = Integer.parseInt(messageParts[1]);

        System.out.println("# Received :" + originMessage + "(duration " + duration + "ms)");

        try{
            int second = duration / 1000;
            for(int i = 0; i < second; i++){
                Thread.sleep(1000);
                System.out.print(".");
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("\n [X] Completed"  + originMessage);
    }

}
