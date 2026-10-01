package com.jjpvt.ai_devops_monitor.service;

import java.time.Instant;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MonitorService {

    private static final Logger log =
            LoggerFactory.getLogger(MonitorService.class);

    public Map<String, Object> getStatus() {
        log.info("Application status checked");

        return Map.of(
                "application", "ai-devops-monitor",
                "status", "UP",
                "timestamp", Instant.now().toString()
        );
    }

    public Map<String, Object> simulateFailure() {
        log.error("Simulated application failure for monitoring test");

        throw new IllegalStateException(
                "Simulated failure: database connection unavailable"
        );
    }
}
