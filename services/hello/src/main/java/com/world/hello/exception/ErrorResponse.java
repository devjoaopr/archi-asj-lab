package com.world.hello.exception;
import java.time.LocalDateTime;
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String correlationId;

    public ErrorResponse(LocalDateTime timestamp, int status, String message, String correlationId) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.correlationId = correlationId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public int getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public String getCorrelationId() {
        return correlationId;
    }
}
