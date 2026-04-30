package com.world.hello.exception;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                MDC.get("correlationId")
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error.toString());
    }
}
