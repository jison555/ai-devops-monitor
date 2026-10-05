package com.jjpvt.ai_devops_monitor.controller;

import java.util.Map;

import com.jjpvt.ai_devops_monitor.service.MonitorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RequestMapping("/api/v1/monitor")
public class MonitorController {

    private final MonitorService monitorService;

    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @GetMapping("/status")
    public Map<String, Object> status() {
        return monitorService.getStatus();
    }
    
    @GetMapping("/test-status")
    public Map<String, Object> test() {
        return monitorService.getStatus();
    }

    @GetMapping("/simulate-error")
    public Map<String, Object> simulateError() {
        return monitorService.simulateFailure();
    }
}

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleException(Exception exception) {
        return Map.of(
                "error", "INTERNAL_SERVER_ERROR",
                "message", "An unexpected error occurred"
        );
    }
}
