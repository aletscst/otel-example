package com.ammfec.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFoundException(NotFoundException exception) {
        log.warn("not found exception: {}", exception.getMessage());

        Map<String, Object> response = new HashMap<>();
        response.put("error", "Not found exception");
        response.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidArgumentsException.class)
    public ResponseEntity<Map<String, Object>> handleNotFoundException(InvalidArgumentsException exception) {
        log.warn("invalid arguments exception: {}", exception.getMessage());

        Map<String, Object> response = new HashMap<>();
        response.put("error", "Invalid arguments exception");
        response.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception exception) {
        log.error("error: {}", exception.getMessage());

        Map<String, Object> response = new HashMap<>();
        response.put("error", "Internal server error");
        response.put("message", exception.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
