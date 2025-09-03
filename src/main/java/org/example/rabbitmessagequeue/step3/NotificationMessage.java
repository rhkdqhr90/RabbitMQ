package org.example.rabbitmessagequeue.step3;

public class NotificationMessage {
    private String message;

    public NotificationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
