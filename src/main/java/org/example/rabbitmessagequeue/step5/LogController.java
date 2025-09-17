package org.example.rabbitmessagequeue.step5;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    private final CustomExceptionHandler customExceptionHandler;

    public LogController(CustomExceptionHandler customExceptionHandler) {
        this.customExceptionHandler = customExceptionHandler;
    }

    @GetMapping("/error")
    public ResponseEntity<String> errorAPI() {
        try {
            String value = null;
            value.getBytes();
        } catch (Exception e) {
            customExceptionHandler.handlerException(e);
        }
        return ResponseEntity.ok("controller Nullpointer Exception 처리");
    }

    @GetMapping("/warn")
    public ResponseEntity<String> warnAPI() {
        try {
            throw new IllegalArgumentException("invalid argument");
        } catch (Exception e) {
            customExceptionHandler.handlerException(e);
        }
        return ResponseEntity.ok("Controller IllegalArgument Exception");
    }

    @PostMapping("/info")
    public ResponseEntity<String> infoAPI(@RequestBody String message) {
        customExceptionHandler.handlerMessage(message);
        return ResponseEntity.ok("controller info log 발송 처러");
    }
}
